package Piece;

import java.awt.image.BufferedImage;

import Board.Board;

public class Rook extends Piece {
    
	public Rook(Board board,int col,int row,Boolean isWhite) {
		super(board);
		this.col = col;
		this.row =row;
		this.x = col * board.squareSize;
		this.y = row* board.squareSize;
		this.isWhite = isWhite;
		this.name ="Rook";
		this.sprite = sheet.getSubimage(4*sheetWidth, isWhite ? 0 : sheetWidth, sheetWidth, sheetWidth).getScaledInstance(board.squareSize,board.squareSize, BufferedImage.SCALE_SMOOTH);
	}
}
