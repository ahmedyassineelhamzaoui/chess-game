package Board;

import Piece.Piece;

public class Game {

	public  Board board;
	public  Player player1;
	public  Player player2;
	
    public Game(Board board,Player player1,Player player2) {
    	this.board = board;
    	this.player1 = player1;
    	this.player2 = player2;
    }


}
