package produtos_organicos;

import java.util.InputMismatchException;
import java.util.Scanner;

import produtos_organicos.model.Produto;
import produtos_organicos.model.ProdutoEmbalado;
import produtos_organicos.model.ProdutoOrganico;
import produtos_organicos.util.Cores;
import produtos_organicos.controller.ProdutoController;


public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	
	public static void testarVisualizar() {
	    ProdutoOrganico p1 = new ProdutoOrganico(1, "Abacate", 1, 9.5f, "Fruta");
	    p1.visualizar();
	}

	// Criando o controlador de produtos
	private static ProdutoController produtoController = new ProdutoController();


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
			System.out.println("6 - Aplicar Desconto            			");
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
				cadastrar();
				keyPress();			
				break;
			case 2:
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Listar todas os Produtos ---\n\n");
				listarTodas();
				keyPress();		
				break;
			case 3: 	
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Buscar Produto por ID ---\n\n");
				buscarPorId();
				keyPress();		
				break;
			case 4: 	
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Atualizar dados do Produto ---\n\n");
				atualizar();
				keyPress();		
				break;
			case 5: 
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Apagar Produto ---\n\n");		
				deletar();
				keyPress();		
				break;
			case 6:
			    System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + "--- Aplicar desconto ---\n\n");        
			    aplicarDesconto();
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
		
	
	// Métodos para o Switch - Interação com usuários:	
	
		//Cadastrar produto:
		private static void cadastrar() {
			System.out.print("Digite o nome do produto: ");
			String nome = leia.nextLine();
			
			System.out.print("Digite a categoria (1-Orgânico | 2-Embalado): ");
			int categoria = leia.nextInt();
			
			System.out.print("Digite o preço: ");
			float preco = leia.nextFloat();
			leia.nextLine(); // limpar buffer
			
			if (categoria == 1) {
				System.out.print("Digite o tipo do orgânico (fruta, legume, grão): ");
				String tipoOrganico = leia.nextLine();
				produtoController.cadastrar(new ProdutoOrganico(produtoController.gerarNumero(), nome, categoria, preco, tipoOrganico));
			} else if (categoria == 2) {
				System.out.print("Digite a marca do produto: ");
				String marca = leia.nextLine();
				produtoController.cadastrar(new ProdutoEmbalado(produtoController.gerarNumero(), nome, categoria, preco, marca));
			} else {
				System.out.println("Categoria inválida!");
			}
		}
		
		// Listar prodto:
		private static void listarTodas() {
			produtoController.listarTodas();
		}
		
		private static void buscarPorId() {
			System.out.print("Digite o ID do produto: ");
			int id = leia.nextInt();
			leia.nextLine();
			
			produtoController.buscarPorId(id);		
		}
		
		// Apagar produto:
		private static void deletar() {		
			System.out.print("Digite o ID do produto: ");
			int id = leia.nextInt();
			leia.nextLine();
			
			Produto produto = produtoController.buscarNaCollection(id);
			
			if(produto != null) {
				System.out.print("\nTem certeza que deseja excluir este produto? (S/N): ");
				String confirmacao = leia.nextLine();
				
				if(confirmacao.equalsIgnoreCase("S")) {
					produtoController.deletar(id);
				}else {
					System.out.println("\nOperação cancelada!");
				}
				
			}else {
				System.out.printf("\nO produto número %d não foi encontrado!", id);
			}
		}
		
		// atualizar produto:
		private static void atualizar() {
			System.out.print("Digite o ID do produto: ");
			int id = leia.nextInt();
			leia.nextLine();
			
			Produto produto = produtoController.buscarNaCollection(id);
			
			if(produto != null) {
				
				System.out.printf("Nome atual: %s\nNovo nome (ENTER para manter): ", produto.getNome()); 
				String entrada = leia.nextLine();
				String nome = entrada.isEmpty() ? produto.getNome() : entrada;
								
				System.out.printf("Preço atual: %.2f\nNovo preço (ENTER para manter): ", produto.getPreco());
				entrada = leia.nextLine();
				float preco = entrada.isEmpty() ? produto.getPreco() : Float.parseFloat(entrada);
					 
				if (produto instanceof ProdutoOrganico) {
					ProdutoOrganico po = (ProdutoOrganico) produto;
					System.out.printf("Tipo atual: %s\nNovo tipo (ENTER para manter): ", po.getTipoOrganico());
					entrada = leia.nextLine();
					String tipoOrganico = entrada.isEmpty() ? po.getTipoOrganico() : entrada;
					produtoController.atualizar(new ProdutoOrganico(id, nome, produto.getCategoria(), preco, tipoOrganico));
					
				} else if (produto instanceof ProdutoEmbalado) {
					ProdutoEmbalado pe = (ProdutoEmbalado) produto;
					System.out.printf("Marca atual: %s\nNova marca (ENTER para manter): ", pe.getMarca());
					entrada = leia.nextLine();
					String marca = entrada.isEmpty() ? pe.getMarca() : entrada;
					produtoController.atualizar(new ProdutoEmbalado(id, nome, produto.getCategoria(), preco, marca));
				}
				
			}else {
				System.out.printf("\nO produto número %d não foi encontrado!", id);
			}
		}
		
		// Se quiser dar desconto
		private static void aplicarDesconto() {
		    System.out.print("Digite o ID do produto: ");
		    int id = leia.nextInt();
		    leia.nextLine();

		    Produto produto = produtoController.buscarNaCollection(id);

		    if (produto != null) {
		        System.out.print("Digite o percentual de desconto: ");
		        float desconto = leia.nextFloat();
		        leia.nextLine();

		        float novoPreco = produto.getPreco() - (produto.getPreco() * desconto / 100);
		        produto.setPreco(novoPreco);

		        System.out.printf("\nDesconto aplicado! Novo preço do produto %s: R$ %.2f\n", produto.getNome(), produto.getPreco());
		    } else {
		        System.out.printf("\nO produto número %d não foi encontrado!\n", id);
		    }
		}

		
	

	}


