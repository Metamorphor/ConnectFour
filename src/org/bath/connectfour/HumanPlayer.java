package org.bath.connectfour;

import java.util.Scanner;


public class HumanPlayer extends Player{
		

	//Constructor creates a token on instantiation
	public HumanPlayer(char token) {
		super(token);

	}
	//Takes input from the human player for column choice. Checks for illegal integer or non-integer input	
	public int getMove() {
        int toReturn = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose which column you would like to play (1 - 7)\n\n");
        try{
            toReturn = scanner.nextInt();
            if(toReturn < 1 || toReturn > 7){
                System.out.print("Incorrect Selection!\n\n");
                getMove();
            }
            else{return toReturn;}
        }
        catch(Exception e){
            System.out.print("Enter an integer only!\n\n");
            toReturn = getMove();

        }
        return toReturn;
    }
	
	}


