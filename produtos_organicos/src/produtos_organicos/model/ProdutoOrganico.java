package produtos_organicos.model;

public class ProdutoOrganico extends Produto {
	
	private String tipoOrganico;

	//Adiciona o Construtor:
	public ProdutoOrganico(int id, String nome, int categoria, float preco, String tipoOrganico) {
		super(id, nome, categoria, preco);
		this.tipoOrganico = tipoOrganico;
	}

	//Adiciona Get e Set:
	public String getTipoOrganico() {
		return tipoOrganico;
	}

	public void setTipoOrganico(String tipoOrganico) {
		this.tipoOrganico = tipoOrganico;
	}
	
	//Adiciona visualizar:
	@Override
	public void visualizar() {		
		super.visualizar();
		System.out.printf("Tipo do Orgânico (fruta, legume, grão): %s%n", this.tipoOrganico);
	}

	
}
