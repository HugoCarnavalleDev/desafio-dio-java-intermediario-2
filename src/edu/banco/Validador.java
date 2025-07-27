package edu.banco;

import java.util.Scanner;

import edu.banco.principal.Main;

public abstract class Validador {
	
	public static int[] NumeroConta(Scanner scanner, int conta, ContaCorrente[] correntes, 
			ContaPoupanca[] poupancas, int[] resultados) {
		
		boolean contaEncontrada = false;
		int i;
		
		if(conta >= 1000 && conta < 5000) { // válida se numero da conta corrente existe			
			i = 0;
			while(i < correntes.length) {
				if(correntes[i].getNumeroConta() == conta) {
					resultados[0] = 1; // retorna que existe uma conta corrente
					resultados[1] = i; // retorna em qual indice a conta está
					System.out.println("Conta corrente válida!");	
					contaEncontrada = true;
					break;
				}					
				i++;
			}
			if(!contaEncontrada) {
				System.out.println("Conta não encontrada! Tente novamente.");
				Main.menuOperacoes(scanner, correntes, poupancas, resultados, conta);
			}			
		} else if(conta >= 5000 && conta < 10000) { // válida se numero da conta poupança existe
			i = 0;
			while(i < poupancas.length) {
				if(poupancas[i].getNumeroConta() == conta) {
					resultados[0] = 2; // retorna que existe uma conta poupança
					resultados[1] = i; // retorna em qual indice a conta está
					System.out.println("Conta poupança válida!");
					contaEncontrada = true;
					break;
				}					
				i++;
			}
			if(!contaEncontrada) {
				System.out.println("Conta não encontrada! Tente novamente.");
				Main.menuOperacoes(scanner, correntes, poupancas, resultados, conta);
			}			
		}
		return resultados; // retorna 2 valores.
	}

}
