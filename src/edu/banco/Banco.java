package edu.banco;

public class Banco {
	private String nome;
	private int numero;
	private int agencia;
	
	public Banco(String nome, int numero, int agencia) {
		this.nome = nome;
		this.numero = numero;
		this.agencia = agencia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getAgencia() {
		return agencia;
	}	
	
	public void imprimirDados() {
		System.out.println("=== Informações do Banco ===");
		System.out.println("Nome: " + getNome());
		System.out.println("Número: " + getNumero());
		System.out.println("Agência: " + getAgencia());
	}
	
}
