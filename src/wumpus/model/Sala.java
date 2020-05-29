package wumpus.model;

public class Sala {
	
	int id;
	boolean visivel;
	Item[] item = new Item[10];
	int cont = 0;
	
	public Sala() {
		this.cont = 0;
	}
	
	public Sala(int id, boolean visivel, Item item) {
		this.id = id;
		this.visivel = visivel;
		this.item[cont] = item;	
		this.cont++;
	}

	public int getId() {
		return id;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public Item[] getItem() {
		return item;
	}	
	
	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public void tornarVisivel() {
		this.visivel = true;
	}
	
	public void Ocultar() {
		this.visivel = false;
	}
	
	public void IncluirItem(Item item) {
		this.item[cont] = item;	
		this.cont++;
	}
	
	//verificar se a sala já esta ocupada
}
