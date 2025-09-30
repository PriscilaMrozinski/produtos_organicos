package produtos_organicos;

import java.util.InputMismatchException;
import java.util.Scanner;

import produtos_organicos.model.ProdutoOrganico;
import produtos_organicos.util.Cores;



public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	
	public static void testarVisualizar() {
	    ProdutoOrganico p1 = new ProdutoOrganico(1, "Abacate", 1, 9.5f, "Fruta");
	    p1.visualizar();
	}


	public static void main(String[] args) {
	
		testarVisualizar();
		
		int opcao;
		
		
while (true) {
			
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_CYAN_BACKGROUND_BRIGHT
			        + "****************************************************");
			System.out.println("------------ Bem-vindo ao Viva Legusta -------------");
			System.out.println("--------- A sua loja de produtos orgânicos ---------");
			System.out.println("****************************************************");
			System.out.println(Cores.TEXT_RESET);
			System.out.println("1 - Cadastrar Produto       				    ");
			System.out.println("2 - Listar todos os Produtos 				");
			System.out.println("3 - Buscar Produto por ID 	 				");
			System.out.println("4 - Atualizar dados do Produto				");
			System.out.println("5 - Apagar Produto             				");
			System.out.println("0 - Sair						  			");
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_CYAN_BACKGROUND_BRIGHT
			        + "****************************************************");
			System.out.println("Digite a opção desejada: 			    ");
			
			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e) {
				opcao = -1;//pode colocar qq número que não seja opções do menu
				System.out.println("\nDigite um número inteiro entre 0 e 5");
				leia.nextLine();
			}
			
			if (opcao==0) {
				System.out.println("\nViva Legusta - Mais que orgânicos. Um jeito de viver!");
				sobre();
				leia.close();
				System.exit(0);
				
			}
						
			switch(opcao) {
			
			case 1:				
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Cadastrar Produto ---\n\n");
				
				keyPress();			
				break;
			case 2:
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Listar todas os Produtos ---\n\n");
				
				keyPress();		
				break;
			case 3: 	
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Buscar Produto por ID ---\n\n");
				
				keyPress();		
				break;
			case 4: 	
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Atualizar dados do Produto ---\n\n");
				
				keyPress();		
				break;
			case 5: 
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Apagar Produto ---\n\n");		
				
				keyPress();		
				break;
			
			case 0: 
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Menu encerrado ---");
				keyPress();		
				break;
			default:
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "Opção Inválida!\n\n");
				keyPress();		
				break;				
			}
		}
	}
	
	
	public static void sobre(){
		System.out.println(Cores.TEXT_RESET);
		System.out.println("\n--------------------------------------------------------");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Priscila Lins Mrozinski ");
		System.out.println("priscila_alins@hotmail.com | github.com/PriscilaMrozinski ");
		System.out.println("----------------------------------------------------------");
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione ENTER para continuar...");
		leia.nextLine();
	}
		

	}


