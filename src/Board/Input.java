package Board;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Piece.Piece;



public class Input extends MouseAdapter {

	public Board board;
	public Input(Board board) {
		this.board = board;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int col = e.getX() / board.squareSize;
		int row = e.getY() / board.squareSize;
		Piece p = board.getPieceAt(col,row);
		if(p !=null) {
			board.selectedPiece = p;
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	   if(board.selectedPiece !=null) {
		   board.selectedPiece.x = e.getX() -30;
		   board.selectedPiece.y = e.getY() -30;
		   board.repaint();
	   }
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		int col = e.getX() / board.squareSize;
		int row = e.getY() / board.squareSize;
		if(board.selectedPiece !=null) {
			Move m = new Move(board,board.selectedPiece,col,row);
			if(board.isValidMove(m)) {
				board.makeMove(m);
			}else {
				board.selectedPiece.x = board.selectedPiece.col * board.squareSize;
				board.selectedPiece.y = board.selectedPiece.row * board.squareSize;
			}
		}
		board.selectedPiece = null;
		board.repaint();
	}
	


}
