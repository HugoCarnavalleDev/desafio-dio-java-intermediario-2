package edu.banco;

public class Cliente {
	private String nomeCompleto;
	private String cpf;
	private String telefone;
	private String cep;
	private double rendaMedia;
	
	public Cliente(String nome, String cpf, String telefone, String cep, double rendaMedia) {
		this.nomeCompleto = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cep = cep;
		this.rendaMedia = rendaMedia;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nome) {
		this.nomeCompleto = nome;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public double getRendaMedia() {
		return rendaMedia;
	}

	public void setRendaMedia(double rendaMedia) {
		this.rendaMedia = rendaMedia;
	}
	
	public void imprimirDados() {
		System.out.println("=== Informações do Cliente ===");
		System.out.println("Nome: " + getNomeCompleto());
		System.out.println("CPF: " + getCpf());
		System.out.println("Telefone: " + getTelefone());
		System.out.println("CEP: " + getCep());
		System.out.println("Renda Média: " + getRendaMedia());
	}
	
}
