package Jogos;

import java.util.Random;
import java.util.Scanner;

public class teste {
	
	public static String nomeP1 = "Danilo";

	public static void main(String[] args) {
		executarJogoForca();
	}
	
	public static int countVitorias;
	public static int countDerrotas;
	public static int countLetras;
	public static char resposta;
	
	public static void executarJogoForca() {
		
		System.out.println("\nJogo da Forca selecionado!");

		char[] letras = gerarPalavra();	
		String[] tracejado = new String[countLetras];

		while (countDerrotas <= 7){
			gerarForca();
			tracejado = gerarTracejado(letras, tracejado);
			if (verificarVitoria(letras, tracejado) == true) {
				imprimirResultado(true);
				break;
			}
			obterResposta();
			validarCaracter(letras);	
			if (countDerrotas >= 7) {
				gerarForca();
				imprimirResultado(false);
				break;
			}
		}
		
	}

	public static char[] gerarPalavra() {

		int index;
		String palavra;

		String[] dados = new String[5];
		dados[0] = "Abacaxi";
		dados[1] = "Goiaba";
		dados[2] = "Berinjela";
		dados[3] = "Tomate";
		dados[4] = "Uva";
		Random aleatorio = new Random();
		index = aleatorio.nextInt(4+1);
		palavra = dados[index];	

		char[] letras = new char[palavra.length()];

		for (int i=0; i<palavra.length(); i++) {
			letras[i] = palavra.charAt(i);
		}

		countLetras = palavra.length();

		return letras;

	}

	public static void validarCaracter(char[] letras) {

		boolean acerto = false;

		for (int i=0; i<letras.length; i++) {
			if (Character.toLowerCase(letras[i]) == Character.toLowerCase(resposta)) {
				acerto = true;
				break;
			}
		}
		
		if (acerto == true) {
			countVitorias++;
		}else {
			countDerrotas++;
		}
	}
	
	public static boolean verificarVitoria(char[] letras, String[] tracejado) {
		String resposta = " ";
		String gabarito = " ";
		boolean resultado = false;
		
		for (int i = 0; i<tracejado.length; i++) {
			resposta += tracejado[i].replace(" ", "");
		}
		
		for (int i = 0; i<letras.length; i++) {
			gabarito += letras[i];
		}
		
		if (resposta.toLowerCase().equals(gabarito.toLowerCase())) {
			resultado = true;
		}
		
		return resultado;
		
	}
	
	public static void gerarForca() {

		System.out.printf("\nVocê deverá acertar a palavra \n"
				+ "em %d tentativas para vencer o jogo. \n", 7-countDerrotas);	

		switch (countDerrotas) {
		case 0: 

			System.out.println("  __________");
			System.out.println(" |          |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|______________");

			break;
		case 1: 
			System.out.println("  __________");
			System.out.println(" |          |");
			System.out.println(" |          0");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|______________");

			break;
		case 2: 
			System.out.println("  __________");
			System.out.println(" |          |");
			System.out.println(" |          0");
			System.out.println(" |          |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|______________");

			break;
		case 3: 
			System.out.println("  __________");
			System.out.println(" |          |");
			System.out.println(" |          0");
			System.out.println(" |         /|");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|______________");

			break;
		case 4: 
			System.out.println("  __________");
			System.out.println(" |          |");
			System.out.println(" |          0");
			System.out.println(" |         /|\\");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|______________");

			break;
		case 5:
			System.out.println("  __________");
			System.out.println(" |          |");
			System.out.println(" |          0");
			System.out.println(" |         /|\\");
			System.out.println(" |          |");
			System.out.println(" |");
			System.out.println("_|______________");

			break;
		case 6: 
			System.out.println("  __________");
			System.out.println(" |          |");
			System.out.println(" |          0");
			System.out.println(" |         /|\\");
			System.out.println(" |          |");
			System.out.println(" |         / ");
			System.out.println("_|______________");

			break;
		case 7:
			System.out.println("  __________");
			System.out.println(" |          |");
			System.out.println(" |          0");
			System.out.println(" |         /|\\");
			System.out.println(" |          |");
			System.out.println(" |         / \\");
			System.out.println("_|______________");

			break;
		}

	}

	public static String[] gerarTracejado(char[] letras, String[] tracejado) {

		if (countVitorias < 1) {
			for (int i=0; i < letras.length; i++) {
				tracejado[i] = "_ ";
			}

		}else{

			for (int i=0; i<letras.length; i++) {
				if (i == 0 && Character.toLowerCase(letras[i]) == Character.toLowerCase(resposta)) {
					tracejado[i] = Character.toUpperCase(resposta) + " ";
				}
				if(i != 0 && Character.toLowerCase(letras[i]) == Character.toLowerCase(resposta)) {
					tracejado[i] = Character.toLowerCase(resposta) + " ";
				}

			}
		}
		for (int i=0; i<letras.length; i++) {
			System.out.print(tracejado[i]);
		}
		
		return tracejado;

	}

	public static void obterResposta() {

		Scanner teclado = new Scanner(System.in);

		System.out.println();
		System.out.println("Digite uma letra:");
		resposta = teclado.next().charAt(0);

	}
	
	public static void imprimirResultado(boolean retorno) {
		if (retorno == true) {
			
			System.out.println();
			System.out.printf("Parabéns, %s! Você ganhou. \n", nomeP1);
			
		}else {
			
			System.out.printf("%s, Você perdeu. \n", nomeP1);
			
		}
	}

}
