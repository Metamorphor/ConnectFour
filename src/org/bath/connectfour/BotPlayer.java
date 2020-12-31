package org.bath.connectfour;

import java.util.Random;

public class BotPlayer extends Player {

	private Random rand;
	
	//Constructor creates a token on instantiation, as well as a random number object
	public BotPlayer(char token) {
		super(token);
		rand = new Random();
	}
	// Chooses a random number for the column form 1-7
	public int getMove() {
		int columnNumber = rand.nextInt(7)+1;
		System.out.print("Bot Player is thinking...\n");
		return columnNumber;
		
	}
}
