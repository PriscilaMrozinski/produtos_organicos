package produtos_organicos.model;

public abstract class Produto {
	
	private int id;
	private String nome;
	private int categoria;
	private float preco;
	
	//Método Construtor:
	public Produto(int id, String nome, int categoria, float preco) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
	}
	
	//Métodos Get e Set:
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
	public void visualizar() {
		String categoria = "";
		switch(this.categoria) {
		case 1 -> categoria = "Produto Orgânico";
		case 2 -> categoria = "Produto Embalado";
		default -> categoria = "Geral";
		}//altera a visualização de número para o nome da categoria
		
		System.out.println("\n *****************");
		System.out.println("Dados do Produto");
		System.out.println("*******************");
		System.out.printf("Id do produto: %d%n", this.id);
		System.out.printf("Nome do produto: %s%n", this.nome);
		System.out.printf("Categoria: %s%n", categoria);
		System.out.printf("Preço: %.2f%n", this.preco);
	}
	
	
	
	
	

}
