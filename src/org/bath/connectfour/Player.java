package org.bath.connectfour;

public abstract class Player {
	
	private char token;
	//Constructor for token creation
	public Player(char token) {
		this.token = token;
	}
	//getMove method will vary between players so must be abstract
	abstract int getMove();
	
	//Allows for the current players token to be retreived
	public char getToken() {
		return token;
	}
}