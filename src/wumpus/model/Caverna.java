package wumpus.model;

public class Caverna {
	
	Sala[][] salas;
	int x;
	int y;
	
	public Caverna() {		
		this.x = 0;
		this.y = 0;
		this.salas = new Sala[10][10];
	}
	
	public Caverna(int x, int y) {
		this.x = 0;
		this.y = 0;
		this.salas = new Sala[x][y];		
	}

	public Sala[][] getSalas() {
		return salas;
	}
	
	public void ocuparSala(Sala sala, int x, int y) {
		//if(!isFull()) 
		//{
		//verifica se a sala já possui algum item, se sim, add item ou sobrescreve o vazio
		if((this.salas[x][y] == null) || (this.salas[x][y].getItem()[0].getAlias() == "V")) {
			this.salas[x][y] = sala;
			this.x++;
			this.y++;
		}
		else {
			this.salas[x][y].IncluirItem(sala.getItem()[0]);		
		}
			
		//}
	}	
	
	public Boolean isFull() {
		int linhas = this.salas.length;
		int colunas = this.salas[0].length;
		if((this.x == linhas) && (this.y == colunas)) {
			return true;
		}
		return false;
	}
	
	public boolean salaOcupada(int x, int y) 
	{
 		if(this.salas[x][y] != null) {
			char item = this.salas[x][y].getItem()[0].getNome().charAt(0);
			if(item == 'V') {
				return false;
			}
			else {
				return true;
			}
		}
		return false;
	}
}
