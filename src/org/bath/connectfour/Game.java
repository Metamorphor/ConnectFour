package org.bath.connectfour;


import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	public static void main(String[] args) {
		Game g = new Game();
		g.playGame();
	}
	
	//While no winner exists, initiate and conduct the players turn, then switch players
    public void playGame(){
    	Board board = new Board();
    	Random rand = new Random();
    	//Starting message
    	System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players: X and O");
        System.out.println("Player 1, you are (X), Player 2 is the computer and is (O)");
        System.out.println("The player to start the game is chosen at random!");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally\n\r");
    	// print board
    	View view = new CLIView();
		view.display(board.toString());
		
    	//ArrayList will hold all players in the game
		ArrayList<Player> players = new ArrayList<>();
		
		players.add(new BotPlayer('O'));
		players.add(new HumanPlayer('X'));
		//Choose the starting player randomly
		int currentPlayer = rand.nextInt(2);
		
		boolean win = false;
		boolean draw = false;
		
		while(!win || !draw) {
			try {
				Player player = players.get(currentPlayer);
				int columnNumber = player.getMove();
			
				//Place the token
				board.placeCounter(player.getToken(), columnNumber);
				//Print the board
				view.display(board.toString());
				//Check for a win
				win = checkWin(player.getToken());
				//Check for a draw
				draw = checkDraw();
				//Change player
				currentPlayer = (currentPlayer+1)%players.size();
			}
			catch(Exception err){
				
			}
		}
		
	}
    
  //Check all possible winning combinations
    public boolean checkWin(char token) {
        boolean hasWon = false;
        int count = 0;
        //Check Diagonals
        // Checks rows: [0][1] to [5][6], [0][2] to [4][6], and [0][3] to [3][6]
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 4 + i; j++) {
                if (Board.board[j][3 - i + j] == token) {
                    count = count + 1;
                    if (count > 3) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        //Checks rows: [2][0] to [5][3], [1][0] to [5][4], and [0][0] to [5][5]
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 6 - i; j++) {
                if (Board.board[i + j][j] == token) {
                    count = count + 1;
                    if (count > 3) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        //Checks rows: [3][0] to [0][3], [4][0] to [0][4], and [5][0] to [0][5]
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 5; j > -1 + i; j--) {
                if (Board.board[j - i][5 - j] == token) {
                    count = count + 1;
                    if (count > 3) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        //Checks rows: [5][3] to [2][6], [5][2] to [1][6], and [5][1] to [0][6]
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 6 - i; j++) {
                if (Board.board[5 - j][j + 1 + i] == token) {
                    count = count + 1;
                    if (count > 3) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        // Checks Horizontals
        for (int i = 0; i < Board.board.length - 1; i++) {
            for (int j = 0; j < Board.board[i].length; j++) {
                if (Board.board[i][j] == token) {
                    count = count + 1;
                    if (count > 3) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }
        // Check Verticals
        for (int i = 0; i < Board.board.length; i++) {
            count = 0;
            for (int j = 5; j > -1; j--) {
                if (Board.board[j][i] == token) {
                    count = count + 1;
                    if (count > 3) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        //Checks for a win and return the result and exits if theres a winner
        if (hasWon) {
            System.out.printf("player %c has Won!!!\n", token);
            System.exit(0);
        }
        return hasWon;
    }
    
    //Checks for a draw (board is full)
    public boolean checkDraw() {
    	//Only need to check the top row is full...
 		for (int i = 0; i<1; i++) {
            int count = 0;
            for (int j = 0; j < Board.board[0].length; j++) {
                if (Board.board[i][j] == 'O' || Board.board[i][j] == 'X') {
                    count = count + 1;
                    if (count > 6) {
                    	System.out.println("\n\nIts a DRAW");
         				return true;
                    }
                }
            }

 		}
 		return false;
    }
    
}

    

