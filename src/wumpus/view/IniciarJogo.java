package wumpus.view;

import java.util.Random;

import wumpus.model.*;

public class IniciarJogo {
	
	public static Caverna CriarMapa(int x, int y, String nome) {
		Caverna caverna = new Caverna(x, y);
		try {			
			Boolean visivel = false;
			Sala sala = new Sala();
			
			System.out.println("verificarMapa");
			caverna = VerificarMapa(caverna);
			//imprimir(caverna);
			
			System.out.println("PosicionarJogador");
			int contSala = caverna.getSalas().length;
			caverna = PosicionarJogador(caverna, contSala);			
			contSala++;
			preecherSalasAdjacentes(caverna, 0, 0, 'J');
			contSala = caverna.getSalas().length + 1;
			//imprimir(caverna);
			
			System.out.println("PosicionarItems");
			caverna = PosicionarItems(caverna, contSala);
			
		}
		catch(Exception e) {
			System.out.println("CriarMapa");
    		System.out.println(e);
		}
			
		return caverna;
	}
	
	private static Item[] CarregarItems() {
		Item[] listaItems = new Item[10];
		listaItems[0] = new Item(1, "Brilho", 10, 0, 0, "*");
		listaItems[1] = new Item(2, "Cheiro", 10, 0, 0,"C");
		listaItems[2] = new Item(3, "Brisa", 10, 0, 0,"~");
		listaItems[3] = new Item(4, "Choque", 100, 0, 0,"c");		
		listaItems[4] = new Item(5, "Grito", 4, 0, 0,"G");		
		listaItems[5] = new Item(6, "Abismo", 10, 0, 2000, "A");
		listaItems[6] = new Item(7, "Vazio", 100, 0, 0, "V");
		listaItems[7] = new Item(8, "Wumpus", 1, 0, 10000, "W");
		listaItems[8] = new Item(9, "Tesouro", 1, 200, 0, "T");
		listaItems[9] = new Item(10, "Saida", 1, 0, 0, "S");
		return listaItems;
	}
	
	private static Comando[] CarregarComandos() {
		//vira_para_direita, vira_para_esquerda, move_para_frente, segura, atira e escala-caverna
		Comando[] listaComando = new Comando[6];
		listaComando[0] = new Comando(1, "vira_para_direita", 1);
		listaComando[1] = new Comando(2, "vira_para_esquerda", 1);
		listaComando[2] = new Comando(3, "move_para_frente", 1);
		listaComando[3] = new Comando(4, "segura", 1);
		listaComando[4] = new Comando(5, "atira", 1);
		listaComando[5] = new Comando(6, "escala-caverna", 1);
		return listaComando;
	}
	
	private static Jogador CriarJogador(String nome) {
		Jogador player1 = new Jogador(1, nome, 1, 2000, 1, 0, 1);
		return player1;
	}
	
	private static Item SelecionarItem() {
		//definir os itens obrigatorios do mapa: Wumpus, tesouro, saida
		Item[] items = CarregarItems();
		Random aleatorio = new Random();
		int i = 0;
		Boolean buscarOutro = true;
		while(buscarOutro) {
			i = SelecionarPosicaoAleatoria(8);
			if(items[i].getQtd() > 0){
				buscarOutro = false;
				items[i].decrementarQuantidade(1);
			}
		}
		return items[i];
	}
	
	private static int SelecionarPosicaoAleatoria(int max) {	
		Random aleatorio = new Random();
		int i = aleatorio.nextInt(max);
		return i;
	}
	
	public static void moverJogador() {
		
	}
	
	private static Caverna PosicionarJogador(Caverna caverna, int contSala) {
		Sala sala = new Sala(contSala, true, CriarJogador("J"));
		caverna.ocuparSala(sala, 0, 0);
		return caverna;
	}
	
	private static Caverna PosicionarItems(Caverna caverna, int contSala) 
	{		
		int x = 0;
		int y = 0;
		Item[] item = CarregarItems();	
		//5-10
		//wumpus-tesouro-abismo-saida
		for(int i = 5; i < 10; i++) {
			do {
				x = SelecionarPosicaoAleatoria(caverna.getSalas().length);
				y = SelecionarPosicaoAleatoria(caverna.getSalas()[0].length);
			} while(caverna.salaOcupada(x, y));
			
			if(i != 6) {
				Sala sala = new Sala(contSala, false, item[i]);			
				caverna.ocuparSala(sala, x, y);				
				preecherSalasAdjacentes(caverna, x, y, item[i].getNome().charAt(0));	
				//imprimir(caverna);
			}			
		}	
		return caverna;
	}
	    
	private static Caverna preecherSalasAdjacentes(Caverna caverna, int x, int y, char aliasItem) {
    	int norte_x = x + 1;
    	int norte_y = y;
    	int sul_x = x - 1;
    	int sul_y = y;
    	int leste_x = x;
    	int leste_y = y - 1;
    	int oeste_x = x;
    	int oeste_y = y + 1;
    	
    	int qtd_row = caverna.getSalas().length;
		int qtd_col = caverna.getSalas()[0].length;
		
		Item item = new Item();
		Sala sala = new Sala();
		
		int contSala = caverna.getSalas().length + 1;
		
		if(aliasItem == 'W') {
			//cheiro
			item = CarregarItems()[1];
		}
		if(aliasItem == 'T') {
			//brilho
			item = CarregarItems()[0];
		}
		if(aliasItem == 'A') {
			//brisa
			item = CarregarItems()[2];
		}
		if((aliasItem == 'J') || (aliasItem == 'S')){
			//vazio
			item = CarregarItems()[6];
		}		
		
		sala = new Sala(contSala, false, item);
    	if(norte_x < qtd_row) {    	    	
    		caverna.ocuparSala(sala, norte_x, norte_y);
    		contSala++;
    	}
    	
    	if (sul_x > 0) {  		
    		caverna.ocuparSala(sala, sul_x, sul_y);
    		contSala++;
    	}
    	
    	if(leste_y > 0) {    			
    		caverna.ocuparSala(sala, leste_x, leste_y);
    		contSala++;
    	}
    	
    	if(oeste_y < qtd_col) {  		
    		caverna.ocuparSala(sala, oeste_x, oeste_y);
    		contSala++;
    	}    	
    	
    	return caverna;
    }
    
    private static Caverna VerificarMapa(Caverna caverna) {
    	try {
	    	int x = caverna.getSalas().length;
	    	int y = caverna.getSalas()[0].length;
	    	Item vazio = CarregarItems()[6]; 
	    	int idSala = caverna.getSalas().length + 1;
	    	for(int i = 0; i < x; i++)
	    	{
	    		for(int j=0; j < y; j++)
	    		{
	    			if((caverna.getSalas()[i][j] == null) || caverna.getSalas()[i][j].getItem() == null) {
	    				Sala sala = new Sala(idSala, false, vazio);
	    				caverna.ocuparSala(sala, i, j);
	    				idSala++;
	    			}
	    			//System.out.print("[" + caverna.getSalas()[i][j].getItem()[0].getNome() + "]");	
	    		}   
	    		//System.out.println();	
	    	}
    	}
    	catch(Exception e) 
    	{
    		System.out.println("verificarMapa-erro");
    		System.out.println(e);
    	}
    	//System.out.println("-----------------------------------------------------------------");
    	return caverna;
    }
    
    public static void imprimir(Caverna caverna) {
    	Sala[][] salas = caverna.getSalas();
    	for (int i=0; i < salas.length; i++)
		{
			for (int j=0; j < salas[0].length; j++)
			{
				if((salas[i][j] != null) || caverna.getSalas()[i][j].getItem()[0] == null) {
					if(!salas[i][j].isVisivel()) {
						for(int t = 0; t < caverna.getSalas()[i][j].getCont(); t++) {
							System.out.print("[" + salas[i][j].getItem()[t].getAlias() + "]");	
						}
					}		
					else {
						System.out.print("[#]");
					}
				}
				else {
					System.out.print("[#]");
				}
			}			
			System.out.println();
		}
    	System.out.println("-----------------------------------------------------------------");
    }
	 
}