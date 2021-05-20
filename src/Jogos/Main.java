package Jogos;

import java.util.Scanner;

public class Main {
	
	public static Scanner Leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao, condicao;
		String nomeP1;
		
		imprimir("Informe o seu nome: ");
		nomeP1 = Leia.nextLine();
		
		do {
			condicao = 0;
			opcao = menu();
			switch (opcao){
			case 1:
				break;
			case 2:
				break;
			case 3:
				jogoDaVelha();
				break;
			case 4:
				condicao = 1;
				imprimirln("\nEncerrando a execução dos jogos.");
				break;
			default:
				imprimirln("\nOpção informada inválida, informe novamente.\n");
				break;
			}
		}while(condicao == 0);

	}
	
	public static int menu() {
		int opcao;
		System.out.println("##---------- Jogos ----------##\n");
		System.out.println("|-----------------------------|");
		System.out.println("| Opção 1 - Jogo da Forca     |");
		System.out.println("| Opção 2 - Batalha Naval     |");
		System.out.println("| Opção 3 - Jogo da Velha     |");
		System.out.println("| Opção 4 - Sair              |");
		System.out.println("|-----------------------------|\n");
		System.out.print("Digite uma opção: ");
		opcao = Leia.nextInt();
		
		return opcao;
	}
	
	public static void imprimirln(String txt) {
		System.out.println(txt);
	}
	
	public static void imprimir(String txt) {
		System.out.print(txt);
	}
	
	//--------------------------------------------------------------Jogo da Velha-----------------------------------------------------------------//
	
	public static void jogoDaVelha() {
		char[][] tabuleiro = {{' ', ' ', ' '},
	                          {' ', ' ', ' '},
	                          {' ', ' ', ' '}};
		efetuarJogada(tabuleiro);		
	}
	
	public static void imprimirtabuleiro (char[][] tabuleiro) {
		for (char [] linha : tabuleiro) {
			imprimirln(" -------------");
			for (char valor : linha) {
				System.out.print(" | " + valor);
			}
			System.out.println(" |");
		}
		imprimirln(" -------------");
	}
	
	public static void efetuarJogada(char[][] tabuleiro) {
		int ganhador = 0, i = 1, j = 0, linha, coluna, condicao2 = 0, contador = 0;
		char[] xo = {'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O'};
		String condicao;
		
		imprimirln("\nJogo da Velha");
		
		do {
			
			imprimirln("\nQuem começa, 'X' ou 'O' ?");
			condicao = Leia.next();
			
			switch (condicao) {
			case "x":; case "X":
				j = 0;
				condicao2 = 1;
				break;
			case "o":; case "O":
				j = 1;
				condicao2 = 1;
				break;
			default:
				imprimirln("\nOpção informada inválida, informe novamente (X ou O).\n");
				break;
			}
		}while(condicao2 == 0);
		
		
		while (ganhador == 0) {
			do {
				
				imprimir(i + "ª jogada da peça "+ xo[j] +" -> Escola a linha (0 a 2): ");
				linha = Leia.nextInt();
				imprimir(i + "ª jogada da peça "+ xo[j] +" -> Escola a linha (0 a 2): ");
				coluna = Leia.nextInt();
				
				if ( verificação(tabuleiro, linha, coluna) ) {
					tabuleiro[linha][coluna] = xo[j];
					imprimirtabuleiro(tabuleiro);
					ganhador = verificarVencedor(tabuleiro, xo[j]);
					
					if (ganhador == 1) {
						imprimirln("\nJogador com a peça " + xo[j] + " foi o vencedor\n" );
					}
					
					j++;
					contador ++;
					
					if (contador % 2 == 0) {
						i++;
					}
					
				}else {
					break;
				}
			}while(ganhador == 0);
		}
		
	}
	
	public static boolean verificação(char[][] tabuleiro, int linha, int coluna) {
		
		if ( (linha >= 0 && linha <= 2) && (coluna >= 0 && coluna <= 2) ) {
			if (tabuleiro[linha][coluna] == ' ') {
				return true;
			}else {
				imprimirln("\nLinha e coluna selecionada já preenchida, informe novo valor de linha e coluna: \n");
				return false;
			}
		}else {
			imprimirln("\nNumero informada inválida, informe novamente.\n");
			return false;
		}
	}
	
	public static int verificarVencedor(char[][] tabuleiro, char xo) {
		if (tabuleiro[0][0] == xo && tabuleiro[0][1] == xo && tabuleiro[0][2] == xo) {
			return 1;
		}else if (tabuleiro[1][0] == xo && tabuleiro[1][1] == xo && tabuleiro[1][2] == xo) {
			return 1;
		}else if (tabuleiro[2][0] == xo && tabuleiro[2][1] == xo && tabuleiro[2][2] == xo) {
			return 1;
		}else if (tabuleiro[0][0] == xo && tabuleiro[1][0] == xo && tabuleiro[2][0] == xo) {
			return 1;
		}else if (tabuleiro[0][1] == xo && tabuleiro[1][1] == xo && tabuleiro[2][1] == xo) {
			return 1;
		}else if (tabuleiro[0][2] == xo && tabuleiro[1][2] == xo && tabuleiro[2][2] == xo) {
			return 1;
		}
		else if (tabuleiro[0][2] == xo && tabuleiro[1][1] == xo && tabuleiro[2][0] == xo) {
			return 1;
		}
		else if (tabuleiro[0][0] == xo && tabuleiro[1][1] == xo && tabuleiro[2][2] == xo) {
			return 1;
		}
		
		return 0;
	}
	
}