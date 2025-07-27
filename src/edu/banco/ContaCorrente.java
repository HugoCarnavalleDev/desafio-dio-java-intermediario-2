package edu.banco;

import java.util.Scanner;

public class ContaCorrente extends Conta{
	
	private double credito;
	
	public ContaCorrente(Banco banco, Cliente cliente, int numeroConta) {
		super(banco, cliente, numeroConta);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirExtrato();
	}
	
//	public void solicitarEmprestimo(double rendaMedia) {
//		credito = 0.25 * rendaMedia;	
//		System.out.println(String.format("Crédito pré-aprovado é de %.2f", credito));	
//	}
	
	public void solicitarEmprestimo() {
		credito = 0.25 * this.getCliente().getRendaMedia();	
		System.out.println(String.format("Crédito pré-aprovado é de %.2f", credito));	
	}
	
	public void contratarEmprestimo(Scanner scanner) {
		System.out.println("Contratar empréstimo? 'S' sim, 'N' não");
		char confirmarEmprestimo = scanner.next().charAt(0);
		
		if(confirmarEmprestimo == 'S' || confirmarEmprestimo == 's') {
			this.depositar(credito);		
			System.out.println("Empréstimo liberado!");	
		} else if (confirmarEmprestimo == 'N' || confirmarEmprestimo == 'n'){
			System.out.println("Empréstimo cancelado!");
		} else {
			System.out.println("Confirmação não reconhecida! Tente novamente.");
			this.contratarEmprestimo(scanner);
		}
		
	}

}
