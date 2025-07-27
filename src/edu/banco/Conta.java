package edu.banco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Conta implements IConta{

	protected int numeroConta;
	protected double saldo = 0.00;
	protected Banco banco;
	protected Cliente cliente;
	
	public int getNumeroConta() {
		return numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public Banco getBanco() {
		return banco;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Conta(Banco banco, Cliente cliente, int numeroConta) {
		this.banco = banco;
		this.cliente = cliente;
		this.numeroConta = numeroConta;
	}	
	
	@Override
	public void sacar(double valorSaque) {
		if(saldo < valorSaque) {
			System.out.println("Saldo insuficiente, verifique seu extrato!");
		} else {
			this.saldo = saldo - valorSaque;
			System.out.println("Saque efetuado!");
		}				
	}

	@Override
	public void depositar(double valorDeposito) {
		this.saldo = saldo + valorDeposito;
		System.out.println("Depósito efetuado!");
	}

	@Override
	public void transferir(double valorTransferencia, Conta contaDestino) {
		if(this.saldo < valorTransferencia) {
			System.out.println("Saldo insuficiente, verifique seu extrato!");
		} else {
			this.sacar(valorTransferencia);
			contaDestino.depositar(valorTransferencia);
			System.out.println("Transferência efetuada!");
		}
	}

	public void formatarData() {
		LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formatter);
		System.out.println("Data impressão " + dataFormatada);
	}
	
	@Override
	public void imprimirExtrato() {
		formatarData();
		System.out.println(String.format("Banco: %d - %s", this.banco.getNumero(), 
				this.banco.getNome()));
		System.out.println(String.format("Agência: %d", this.banco.getAgencia()));
		System.out.println(String.format("Cliente: %s", this.cliente.getNomeCompleto()));
		System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
	}
	
}
