package edu.banco;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(Banco banco, Cliente cliente, int numeroConta) {
		super(banco, cliente, numeroConta);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirExtrato();
	}
}
