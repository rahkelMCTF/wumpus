package wumpus.model;

//brilho, cheiro, brisa, choque, grito, Wumpus, abismo, tesouro, saida
//choque: batida nas bordas do mapa
//cheiro: fica nos quadrados ao redor do Wumpus
//brilho: aparece nos quadrados proximos ao tesouro
//brisa: aparece nos quadrados proximos ao abismo
//grito: aparece em todas as salas se o wumpus morrer
public class Item {	
	
	int id;
	String nome;
	String alias;
	int qtd;
	int posicao_x;
	int posicao_y;
	int beneficio;
	int penitencia;
	
	public Item() {

	}
	
	public Item(int id, String nome, int qtd, int beneficio, int penitencia, String alias) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtd = qtd;
		this.beneficio = beneficio;
		this.penitencia = penitencia;
		this.alias = alias;
	}

	public Item(int id, String nome, int qtd, int beneficio, int penitencia, int posicao_x, int posicao_y) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtd = qtd;
		this.beneficio = beneficio;
		this.penitencia = penitencia;
		this.posicao_x = posicao_x;
		this.posicao_y = posicao_y;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getQtd() {
		return qtd;
	}

	public int getPosicao_x() {
		return posicao_x;
	}

	public int getPosicao_y() {
		return posicao_y;
	}
	
	public int getBeneficio() {
		return beneficio;
	}

	public int getPenitencia() {
		return penitencia;
	}
	
	public String getAlias() {
		return alias;
	}

	public void inserirPosicao(int x, int y) 
	{
		this.posicao_x = x;
		this.posicao_y = y;
	}
	
	public void decrementarQuantidade(int decremento) {
		this.qtd = this.qtd - decremento;
	}
}
