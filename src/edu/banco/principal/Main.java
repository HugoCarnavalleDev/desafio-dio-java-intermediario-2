package edu.banco.principal;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import edu.banco.Banco;
import edu.banco.Cliente;
import edu.banco.ContaCorrente;
import edu.banco.ContaPoupanca;
import edu.banco.Validador;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Parte 1 - Cadastro dos Bancos
		System.out.println("Bem-vindo ao Sistema Bancário!");
		System.out.println("Informe quantos bancos você deseja cadastrar.");
		
		int tamanho = scanner.nextInt();		
		validarTamanhoVetor(tamanho, scanner);
		
		int posicaoVetorBancos = 0;		
		Banco[] bancos = new Banco[tamanho];	
		
		do {			
			System.out.println((posicaoVetorBancos + 1) + "º Banco:");
			System.out.println("Digite um nome: ");
			String banco = scanner.next();
			System.out.println("Digite um numero: ");
			int numero = scanner.nextInt();
			System.out.println("Digite uma agência: ");
			int agencia = scanner.nextInt();
					
			bancos[posicaoVetorBancos] = new Banco(banco, numero, agencia);
					
			posicaoVetorBancos++;
						
		} while(posicaoVetorBancos < tamanho);			
		
		
		// Parte 2 - Cadastro de Clientes
		System.out.println("Cadastro de clientes");
		System.out.println("Informe quantos clientes você deseja cadastrar.");
		
		tamanho = scanner.nextInt();
		validarTamanhoVetor(tamanho, scanner);	
		
		int posicaoVetorClientes = 0;
		Cliente[] clientes = new Cliente[tamanho];
		
		do {
				
			System.out.println((posicaoVetorClientes + 1) + "º Cliente:");			
			System.out.println("Digite um nome completo: ");
			String nomeCompleto = scanner.next();
			
			System.out.println("Digite um CPF: ");
			String cpf = scanner.next();
			
			System.out.println("Digite um telefone: ");
			String telefone = scanner.next();
			
			System.out.println("Digite um CEP: ");
			String cep = scanner.next();
			
			System.out.println("Digite a renda média: ");
			double rendaMedia = scanner.nextDouble();
			
			clientes[posicaoVetorClientes] = new Cliente(nomeCompleto, cpf, telefone, cep, rendaMedia);
			
			posicaoVetorClientes++;
			
		} while(posicaoVetorClientes < tamanho);
		
		// Parte 3 - Cadastro de contas
		System.out.println("Cadastro de contas");
		System.out.println("Informe quantas contas você deseja cadastrar.");
		
		tamanho = scanner.nextInt();
		validarTamanhoVetor(tamanho, scanner);	
		
		int posicaoVetorContas = 0;
		ContaCorrente[] correntes = new ContaCorrente[tamanho];
		ContaPoupanca[] poupancas = new ContaPoupanca[tamanho];
		
		do {
				
			System.out.println((posicaoVetorContas + 1) + "º Conta:");			
			System.out.println("Informe o código do banco: ");						
			for(int i = 0; i < bancos.length; i++) {
				System.out.print("** " + (i + 1) + " - " + bancos[i].getNome() + " **");
			}			
			int codigoBanco = scanner.nextInt();
			
			System.out.println("Informe o código do cliente: ");
			for(int i = 0; i < clientes.length; ++i) {
				System.out.println((i + 1) + " - " + clientes[i].getNomeCompleto());
			}		
			int codigoCliente = scanner.nextInt();
			
			int numeroContaCorrente = ThreadLocalRandom.current().nextInt(1000,4999);
			int numeroContaPoupanca = ThreadLocalRandom.current().nextInt(5000,9999);
			
			correntes[posicaoVetorContas] = new ContaCorrente(bancos[codigoBanco-1], clientes[codigoCliente-1], numeroContaCorrente);
			poupancas[posicaoVetorContas] = new ContaPoupanca(bancos[codigoBanco-1], clientes[codigoCliente-1], numeroContaPoupanca);
			
			System.out.println("O numero da sua conta corrente é: " + correntes[posicaoVetorContas].getNumeroConta());
			System.out.println("O numero da sua conta poupança é: " + poupancas[posicaoVetorContas].getNumeroConta());
			
			posicaoVetorContas++;
			
		} while(posicaoVetorContas < tamanho);
		
		//Parte 4 - Realizar movimentações bancárias		
		int[] resultados = new int[2];
		
		System.out.println(String.format("\nAcessando sua conta: "));
		System.out.println("Informe o numero da conta desejada:");		
		int conta = scanner.nextInt();	
		
		for(int j = 1; j <= 4; j++) { // caso a validação não encontre a conta, há 3 tentativas.		
			Validador.NumeroConta(scanner, conta, correntes, poupancas, resultados);
			if(resultados[0] == 1 || resultados[0] == 2) {
				menuOperacoes(scanner, correntes, poupancas, resultados, conta);
				
				// Parte 5 - Consultar cadastros e movimentação		
				menuConsulta(scanner, bancos, clientes, correntes, poupancas);
				
				break;
			} else if(j == 4) {
				System.out.println("Numero de tentativas excedidas!");
				break;
			}
		}
		
		scanner.close();		
	}
	
	public static int validarTamanhoVetor(int tamanho, Scanner scanner) {
		
		while(tamanho < 1) {
			System.out.println(String.format("Valor inválido! Tente novamente. "
					+ "%nValor deve ser maior que 0!"));
			tamanho = scanner.nextInt();
		}
							
		return tamanho;
	}
	
	public static void menuOperacoes(Scanner scanner, ContaCorrente[] correntes, ContaPoupanca[] poupancas, 
			int[] resultados, int conta) {
		
		System.out.println("Selecione a operação desejada: ");
		System.out.println("1 - Depositar");
		System.out.println("2 - Sacar");
		System.out.println("3 - Transferir");
		System.out.println("4 - Emprestimo Pré-aprovado");
		System.out.println("5 - Finalizar operação");		
		int operacao = scanner.nextInt();
	
		int tipoConta = resultados[0]; // retorna que a conta existe e o tipo dela 
		int localConta = resultados[1]; // retorna em qual indice a conta está
		char continuarOperacao;
		
		switch(operacao) {
			case 1:
				System.out.println("Informe o valor do depósito: ");
				double valorDeposito = scanner.nextDouble();
				if(tipoConta == 1) {
					correntes[localConta].depositar(valorDeposito);
				} else {
					poupancas[localConta].depositar(valorDeposito);
				}
				System.out.println("Realizar nova operação? 'S' sim, 'N' não");
				continuarOperacao = scanner.next().charAt(0);
				if(continuarOperacao == 'S' || continuarOperacao == 's') {
					menuOperacoes(scanner, correntes, poupancas, resultados, conta);
				}
				break;
			case 2:
				System.out.println("Informe o valor do saque: ");
				double valorSaque = scanner.nextDouble();
				if(tipoConta == 1) {
					correntes[localConta].sacar(valorSaque);
				} else {
					poupancas[localConta].sacar(valorSaque);
				}
				System.out.println("Realizar nova operação? 'S' sim, 'N' não");
				continuarOperacao = scanner.next().charAt(0);
				if(continuarOperacao == 'S' || continuarOperacao == 's') {
					menuOperacoes(scanner, correntes, poupancas, resultados, conta);
				}
				break;
			case 3:
				System.out.println("Informe o valor da transferência: ");
				double valorTransferencia = scanner.nextDouble();
				
				System.out.println("Informe o numero da conta de destino: ");
				int contaDestino = scanner.nextInt();
								
				if(tipoConta == 1) {
					Validador.NumeroConta(scanner, contaDestino, correntes, poupancas, resultados);
					contaDestino = resultados[1];
					correntes[localConta].transferir(valorTransferencia, correntes[contaDestino]);
					
					resultados[0] = tipoConta; // retorna que a conta existe e o tipo dela 
					resultados[1] = localConta; // retorna em qual indice a conta está
				} else {
					Validador.NumeroConta(scanner, contaDestino, correntes, poupancas, resultados);
					contaDestino = resultados[1];
					poupancas[localConta].transferir(valorTransferencia, poupancas[contaDestino]);
				}
				System.out.println("Realizar nova operação? 'S' sim, 'N' não");
				continuarOperacao = scanner.next().charAt(0);
				if(continuarOperacao == 'S' || continuarOperacao == 's') {
					menuOperacoes(scanner, correntes, poupancas, resultados, conta);
				}
				break;
			case 4:
				if(tipoConta == 1) {
					// correntes[localConta].solicitarEmprestimo(correntes[localConta].getCliente().getRendaMedia());
					correntes[localConta].solicitarEmprestimo();					
					correntes[localConta].contratarEmprestimo(scanner);					
				} else {
					System.out.println("Linha de crédito disponível apenas para Conta Corrente.");
				}				
				
				System.out.println("Realizar nova operação? 'S' sim, 'N' não");
				continuarOperacao = scanner.next().charAt(0);
				if(continuarOperacao == 'S' || continuarOperacao == 's') {
					menuOperacoes(scanner, correntes, poupancas, resultados, conta);
				}
				break;				
			case 5:
				System.out.println("Operação finalizada");
				break;
			default:
				System.out.println("Operação não localizada! Tente novamente.");	
				System.out.println("Realizar nova operação? 'S' sim, 'N' não");
				continuarOperacao = scanner.next().charAt(0);
				if(continuarOperacao == 'S' || continuarOperacao == 's') {
					menuOperacoes(scanner, correntes, poupancas, resultados, conta);
				}
		}
	}
	
	public static void menuConsulta(Scanner scanner, Banco[] bancos, Cliente[] clientes, ContaCorrente[] correntes, ContaPoupanca[] poupancas) {
		System.out.println(String.format("%nO que você deseja fazer a seguir?"));
		System.out.println("1 - Consultar Bancos Cadastrados");
		System.out.println("2 - Consultar Clientes Cadastrados");
		System.out.println("3 - Consultar Extrato Conta Corrente");
		System.out.println("4 - Consultar Extrato Conta Poupança");
		System.out.println("5 - Sair");
		
		int opcao = scanner.nextInt();
				
		switch(opcao) {
			case 1:
				for(int i = 0; i < bancos.length; i++) {
					bancos[i].imprimirDados();
				}
				menuConsulta(scanner, bancos, clientes, correntes, poupancas);
				break;
			case 2:
				for(int i = 0; i < clientes.length; i++) {
					clientes[i].imprimirDados();
				}
				menuConsulta(scanner, bancos, clientes, correntes, poupancas);
				break;
			case 3:
				for(int i = 0; i < correntes.length; i++) {
					correntes[i].imprimirExtrato();
				}
				menuConsulta(scanner, bancos, clientes, correntes, poupancas);
				break;
			case 4:
				for(int i = 0; i < poupancas.length; i++) {
					poupancas[i].imprimirExtrato();
				}
				menuConsulta(scanner, bancos, clientes, correntes, poupancas);
				break;
			case 5:
					System.out.println("Sistema finalizado!");
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
				menuConsulta(scanner, bancos, clientes, correntes, poupancas);
		}
	}
}
