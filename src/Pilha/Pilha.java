package Pilha;

import java.util.Scanner;

public class Pilha {
	
	public static void main(String[] args) {
		
		Caixa[] caixas = new Caixa[10];
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println("----------------------------------");
		System.out.println("Gerenciamento de caixas");
		System.out.println("----------------------------------");
		
		while(opcao != 3){
			System.out.println("----------------------------------");
			System.out.println("1 - Empilhar Caixa");
			System.out.println("2 - Desimpilhar Caixa");
			System.out.println("3 - Sair");
			System.out.println("----------------------------------");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1: {
				
				if(caixas[0] == null) {
					Caixa caixa = new Caixa();
					
					System.out.println("Identificador: ");
					caixa.setIdentificador(sc.next());
					
					System.out.println("Altura: ");
					caixa.setAltura(sc.nextDouble());
					
					System.out.println("Largura: ");
					caixa.setLargura(sc.nextDouble());
					
					System.out.println("Profundidade: ");
					caixa.setProfundidade(sc.nextDouble());
					
					System.out.println("É conteúdo frágil? ");
					char fragil = sc.next().charAt(0);
					
					if(fragil == 'S' || fragil == 's') {
						caixa.setConteudoFragil(true);
					}else {
						caixa.setConteudoFragil(false);
					}
					
					caixas = empilhar(caixa, caixas);
				}else {
					System.out.println("Pilha está cheia!");
				}
				
				break;
			}
			case 2: {
				caixas = desempilhar(caixas);
				break;
			}
			case 3: {
				System.out.println("Saindo...");
				break;
			}
			default:
				System.out.println("Opção Inválida! - Tente novamente");
				break;
			}
		}
		
		sc.close();
	}
	
	/**
	 * 
	 * Empilha a caixa no primeiro espaço vazio em ordem inversa
	 *
	 * @author Breno
	 * @param caixa
	 * @param caixas
	 * @return caixas
	 */
	public static Caixa[] empilhar(Caixa caixa, Caixa[] caixas){
		for (int i = caixas.length-1; i >= 0; i--) {
			if(caixas[i] == null) {
				caixas[i] = caixa;
				break;
			}
			//Verifica se a pilha está vazia  
			if(i == 0) {
				System.out.println("A pilha está cheia!");
			}
		}
		return caixas;
	}
	
	/**
	 * 
	 * Desempilhando do vetor a caixa na ordem de retirada 
	 *
	 * @author Breno
	 * @param caixas
	 * @return
	 */
	public static Caixa[] desempilhar(Caixa[] caixas){
		for (int i = 0; i < caixas.length; i++) {
			if(caixas[i] != null) {
				caixas[i] = null;
				System.out.println("Caixa retirada!");
				break;
			}
			//Verifica se a pilha está vazia  
			if(i == caixas.length-1) {
				System.out.println("A pilha está vazia!");
			}
		}
		return caixas;
	}
}
