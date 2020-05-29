//autor: Raquel Figueiredo
//Mundo dos wumpus
package wumpus.view;

import wumpus.model.*;

public class Main {

	public static void main(String[] args) 
	{
		try 
		{
			int x = 5;
			int y = 5;
			Caverna caverna = IniciarJogo.CriarMapa(x,y,"Raquel");
			Sala[][] salas = caverna.getSalas();
			//System.out.println("[0][1][2][3]");
			IniciarJogo.imprimir(caverna);	
		}
		catch(Exception e) {
			System.out.println(e);
		}		
	}

}
