package wumpus.model;

public class Wumpus extends Item {
	
	int vidas;
	
	public Wumpus() {
		super();
		this.vidas = 1;
	}
	
	
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}


	public int getVidas() {
		return vidas;
	}


	public Boolean isAlive() {
		if(vidas > 0)
			return true;
		return false;
	}
	
	public void atualizarStatus(int vidas) {
		setVidas(vidas);
	}
	
}
