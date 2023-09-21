package Piece;

import java.awt.image.BufferedImage;

import Board.Board;

public class Pawn extends Piece {

	public Pawn(Board board,int col,int row,boolean isWhite) {
		super(board);
		this.row = row;
		this.col = col;
		this.x = col * board.squareSize;
		this.y = row * board.squareSize;
		this.isWhite = isWhite;
		this.name ="Pawn";
		this.sprite = sheet.getSubimage(5*sheetWidth, isWhite ? 0 : sheetWidth, sheetWidth , sheetWidth).getScaledInstance(board.squareSize, board.squareSize, BufferedImage.SCALE_SMOOTH);
	}
}
