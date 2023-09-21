package Board;

import Piece.Piece;

public class Move {

	public int oldcol;
	public int oldrow;
	public int newcol;
	public int newrow;
	
	Piece piece;
	Piece capture;
	public Move(Board board,Piece piece,int newcol,int newrow) {
		this.oldcol = piece.col;
		this.oldrow = piece.row;
		this.newrow = newrow;
		this.newcol = newcol;
		this.piece = piece;
		this.capture = board.getPieceAt(newcol, newrow);
	}

}
