package wumpus.model;

//vira_para_direita, vira_para_esquerda, move_para_frente, segura, atira e escala-caverna
public class Comando {
	int id;
	String descricao;
	int penitencia;
	
	public Comando() {
		
	}

	public Comando(int id, String descricao, int penitencia) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.penitencia = penitencia;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getPenitencia() {
		return penitencia;
	}	
}
