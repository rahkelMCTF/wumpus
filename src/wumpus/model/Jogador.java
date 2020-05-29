package wumpus.model;

public class Jogador extends Item{
	
	int pontuacao;
	int posicao_frente_x;
	int posicao_frente_y;
	int flecha;
	Item item_coletado;	
	Comando movimentos_executados[];
	int cont_mov;
	int vidas;
	
	public Jogador() {
		movimentos_executados = new Comando[100];
		cont_mov = 0;
		item_coletado = new Item();
	}

	public Jogador(int id, String nome, int qtd, int pontuacao, int posicao_frente_x, int posicao_frente_y, int flecha) {
		super(id, nome, qtd, 0, 0, "J");
		this.pontuacao = pontuacao;
		this.posicao_frente_x = posicao_frente_x;
		this.posicao_frente_y = posicao_frente_y;
		this.flecha = flecha;
		this.movimentos_executados = new Comando[100];
		this.cont_mov = 0;
		item_coletado = new Item();
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public int getPosicao_frente_x() {
		return posicao_frente_x;
	}

	public int getPosicao_frente_y() {
		return posicao_frente_y;
	}

	public int getFlecha() {
		return flecha;
	}

	public Item getItem_coletado() {
		return item_coletado;
	}

	public Comando[] getMovimentos_executados() {
		return movimentos_executados;
	}	
	
	public void CadastrarMovimento(Comando comando) {
		this.movimentos_executados[this.cont_mov] = comando;
		this.cont_mov++;
	}
}
