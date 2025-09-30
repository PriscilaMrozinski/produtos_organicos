package repository;

import produtos_organicos.model.Produto;

public interface ProdutoRepository {
	
	// Métodos do CRUD
	public void cadastrar(Produto produto);
	public void listarTodas();
	public void buscarPorId(int numero);
	public void atualizar(Produto produto);
	public void deletar(int numero);
	public void aplicarDesconto(int numero);
	
	
}