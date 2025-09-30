package produtos_organicos.controller;

import java.util.ArrayList;
import java.util.List;

import produtos_organicos.model.Produto;
import repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	//Criar lista, para o Método ListarTodas:
		private List<Produto> listaProdutos =new ArrayList<Produto>();
		int id = 0;//variável para controlar os números das produtos
		
		
		@Override
		public void listarTodas() {
			for(var produto : listaProdutos) {
				produto.visualizar();
			}
		}

		@Override
		public void cadastrar(Produto produto) {
			listaProdutos.add(produto);
			System.out.println("Produto cadastrado com sucesso");
		}

		@Override
		public void atualizar(Produto produto) {
				var buscarProduto = buscarNaCollection(produto.getId());
				if(buscarProduto!=null) {
					listaProdutos.set(listaProdutos.indexOf(buscarProduto), produto);
					System.out.printf("\nO produto número: %d foi atualizado com sucesso!%n", produto.getId());
				}else {
					System.out.printf("\nO Produto número: %d não foi encontrado!%n", produto.getId());
				}
		}
			

		@Override
		public void buscarPorId(int id) {
			var produto = buscarNaCollection(id);
			if(produto!=null) {
				produto.visualizar();
			}else {
				System.out.printf("\nO Produto número: %d não foi encontrado!%n", id);
			}
		}

		@Override
		public void deletar(int id) {
			var produto = buscarNaCollection(id);
			if(produto!=null) {
				if(listaProdutos.remove(produto) == true) {
					System.out.printf("\nO produto número %d foi deletado com sucesso!%n", id);
				}//se realmente apagou a produto
			}else {
				System.out.printf("\nO Produto número: %d não foi encontrado!%n", id);
			}
		}


		
		//Métodos Auxiliares:
		public int gerarNumero() {
			return ++ id;
		}
		
		//Método que será usado para vários outros métodos:
		public Produto buscarNaCollection(int id) {
			for(var produto : listaProdutos) {
				if(produto.getId() == id){
					return produto;
				}
			}
			return null;//esse bloco é um exemplo de Optional
		}
	

}
