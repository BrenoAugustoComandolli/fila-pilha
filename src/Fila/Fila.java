package Fila;

import java.util.Scanner;

public class Fila {
	
	public static void main(String[] args) {
		
		Paciente[] pacientes = new Paciente[20];
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println("----------------------------------");
		System.out.println("Gerenciamento de pacientes");
		System.out.println("----------------------------------");
		
		while(opcao != 3){
			System.out.println("----------------------------------");
			System.out.println("1 - Incluir Paciente");
			System.out.println("2 - Atender Paciente");
			System.out.println("3 - Sair");
			System.out.println("----------------------------------");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1: {
				
				pacientes = incluirPaciente(new Paciente(), sc, pacientes);
				break;
			}
			case 2: {
				
				int tipoAtendimento = 1;
				
				do {
					System.out.println("----------------------------------");
					System.out.println("1- Atender por nome");
					System.out.println("2- Atender por ordem");
					System.out.println("----------------------------------");
					tipoAtendimento = sc.nextInt();
					
					if(tipoAtendimento == 1 || tipoAtendimento == 2) {
						pacientes = AtenderPaciente(tipoAtendimento, sc, pacientes);
					}else {
						System.out.println("Opção inválida!");
					}
					
				}while(tipoAtendimento != 1 && tipoAtendimento != 2);
				
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
	 * Inclui um paciente na fila de espera 
	 *
	 * @author Breno
	 * @param paciente
	 */
	public static Paciente[] incluirPaciente(Paciente paciente, Scanner sc, Paciente[] pacientes) {
		
		if(pacientes[pacientes.length-1] == null) {
			
			//Limpa o scanner 
			sc.nextLine();
			
			System.out.println("Nome: ");
			paciente.setNome(sc.nextLine());
			
			System.out.println("Idade: ");
			paciente.setIdade(sc.nextInt());
			
			//Limpa o scanner 
			sc.nextLine();
			
			System.out.println("Descrição: ");
			paciente.setDescricao(sc.nextLine());
			
			//Adiciona paciente na fila
			for (int i = 0; i < pacientes.length; i++) {
				if(pacientes[i] == null) {
					pacientes[i] = paciente;
					break;
				}
			}
			
		}else {
			System.out.println("Fila de atendimento está cheia!");
		}
		
		return pacientes;
	}
	
	/**
	 * 
	 * Atende um paciente, assim removendo ele da lista
	 *
	 * @author Breno
	 * @param nome
	 */
	public static Paciente[] AtenderPaciente(int tipoAtendimento, Scanner sc, Paciente[] pacientes) {
		
		if(tipoAtendimento == 1) {
			
			//Limpa o scanner 
			sc.nextLine();
			
			System.out.println("Informe o paciente atendido: ");
			String nome = sc.nextLine();
			
			for (int i = 0; i < pacientes.length; i++) {
				
				if(pacientes[i] != null) {
					if(pacientes[i].getNome().equals(nome)) {
						pacientes[i] = null;
						System.out.println("Cliente atendido!");
						break;
					}
				}
				
				//Verifica se há elementos na fila com esse nome 
				if(i == pacientes.length-1) {
					System.out.println("Cliente não está na fila!");
				}
			}
			
		}else {
			for (int i = 0; i < pacientes.length; i++) {
				
				//Remove cliente da fila 
				if(pacientes[i] != null) {
					pacientes[i] = null;
					System.out.println("Cliente atendido!");
					break;
				}
				
				//Verifica se há elementos na fila 
				if(i == pacientes.length-1) {
					System.out.println("Sem clientes na fila!");
				}
			}
		}
		
		return reorganizaFila(pacientes);
	}
	
	/**
	 * 
	 * Reorganiza a fila
	 *
	 * @author Breno
	 * @param pacientes
	 */
	public static Paciente[] reorganizaFila(Paciente[] pacientes) {
		for (int i = 0; i < pacientes.length; i++) {
			//Verifica se há linha vazia e se tem proximo na fila
			if(pacientes[i] == null && (i+1) < pacientes.length) {
				for (int j = i; j < pacientes.length-1; j++) {
					Paciente pacienteTroca = pacientes[j];
					pacientes[j] = pacientes[j+1];
					pacientes[j+1] = pacienteTroca;
				}
			}
		}
		
		return pacientes;
	}
}
