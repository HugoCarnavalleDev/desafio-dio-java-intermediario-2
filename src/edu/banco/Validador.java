package edu.banco;

import java.util.Scanner;

import edu.banco.principal.Main;

public abstract class Validador {
	
	public static int[] NumeroConta(Scanner scanner, int conta, ContaCorrente[] correntes, ContaPoupanca[] poupancas, int[] resultados) {
		boolean contaEncontrada = false;
		int i;
		
		if(conta >= 1000 && conta < 5000) {
			// válida conta corrente			
			i = 0;
			while(i < correntes.length) {
				if(correntes[i].getNumeroConta() == conta) {
					resultados[0] = 1;
					resultados[1] = i;
					System.out.println("Conta corrente valídada!");	
					contaEncontrada = true;
					break;
				}					
				i++;
			}
			if(!contaEncontrada) {
				System.out.println("Conta não encontrada! Tente novamente.");
				Main.menuOperacoes(scanner, correntes, poupancas, resultados);
			}			
		} else if(conta >= 5000 && conta < 10000) { 
			// válida conta corrente
			i = 0;
			while(i < poupancas.length) {
				if(poupancas[i].getNumeroConta() == conta) {
					resultados[0] = 2;
					resultados[1] = i;
					System.out.println("Conta poupança valídada!");
					contaEncontrada = true;
					break;
				}					
				i++;
			}
			if(!contaEncontrada) {
				System.out.println("Conta não encontrada! Tente novamente.");
				Main.menuOperacoes(scanner, correntes, poupancas, resultados);
			}			
		}
		return resultados;
	}

}
