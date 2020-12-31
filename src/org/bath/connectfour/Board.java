package org.bath.connectfour;

import java.util.Scanner;

public class Board {
	
	static char[][] board;
	
	//Constructor - Produce an array that will act as the board
    public Board(){
        board = new char[7][7];
    }
    
  //Place the players counter in the chosen column after checking the first empty spot in the column
    public void placeCounter(char token, int position) throws Exception{
        boolean placed = false;
        for(int i = 5; i>-1; i--){
            if(!placed){
                if(board[i][position - 1] == 'X' || board[i][position - 1] == 'O'){
                	//Catch an exception if either player tries to choose a full column
                	if((board[0][position - 1] == 'X' || board[0][position - 1] == 'O') && (token == 'X')) {
                		System.out.println("This Column is full! Choose again...");
                		throw new Exception();
                	}
                	else if((board[0][position - 1] == 'X' || board[0][position - 1] == 'O') && (token == 'O')) {
                		throw new Exception();
                	}
                }
                else if(board[i][position - 1] != token){
                        board[i][position - 1] = token;
                        placed = true;
                    }

            }
        }
    }
  //Creates a string that can be passed to the interface for display
    public String toString(){
    	String toReturn = "";
        for(int i=0; i<board.length-1; i++){
            for(int j=0; j<board[i].length; j++){
                char boardCounter = board[i][j];
                if (boardCounter == '\0')
                  toReturn += "|   ";
                else{
                  toReturn += "| " + boardCounter + " ";
                }
            }
            toReturn += ("|\n");
        }
        toReturn +="  1   2   3   4   5   6   7 \r\n";
        return toReturn;
    }
    
    
    
}
