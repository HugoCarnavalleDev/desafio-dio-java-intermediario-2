package edu.banco;

public class ContaCorrente extends Conta{
	
	public ContaCorrente(Banco banco, Cliente cliente, int numeroConta) {
		super(banco, cliente, numeroConta);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirExtrato();
	}

}
