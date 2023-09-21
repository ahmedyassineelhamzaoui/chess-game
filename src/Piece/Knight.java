package Piece;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Board.Board;

public class Knight extends Piece {
 
	public Knight(Board board, int col, int row, boolean isWhite) {
	    super(board);
	    this.col = col;
	    this.row = row;
	    this.x = col * board.squareSize;
	    this.y = row * board.squareSize;
	    this.isWhite = isWhite;
	    this.name = "knight";
	    this.sprite = sheet.getSubimage(3*sheetWidth, isWhite ? 0  :sheetWidth, sheetWidth, sheetWidth).getScaledInstance(board.squareSize, board.squareSize, BufferedImage.SCALE_SMOOTH);
	   }

}	
