package Piece;

import java.awt.image.BufferedImage;

import Board.Board;

public class Bishop extends Piece {

	public Bishop(Board board,int col,int row,boolean isWhite) {
		super(board);
		this.col = col;
		this.row = row;
		this.isWhite = isWhite;
		this.x = col * board.squareSize;
		this.y = row * board.squareSize;
		this.name ="Bishop";
		this.sprite = sheet.getSubimage(2*sheetWidth,  isWhite ? 0  :sheetWidth, sheetWidth, sheetWidth).getScaledInstance(board.squareSize, board.squareSize, BufferedImage.SCALE_SMOOTH);
	}
}
