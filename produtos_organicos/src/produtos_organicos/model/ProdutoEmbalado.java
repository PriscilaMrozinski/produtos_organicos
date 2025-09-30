package produtos_organicos.model;

public class ProdutoEmbalado extends Produto {
	
	private String marca;
	
	//Método Construtor:
	public ProdutoEmbalado(int id, String nome, int categoria, float preco, String marca) {
		super(id, nome, categoria, preco);
		this.marca = marca;
	}

	//Métodos Get e Set
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	//Método Visualizar
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("Marca: %s%n", this.marca);
	}
	
	

}
