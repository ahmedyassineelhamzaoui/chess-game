package Piece;

import Board.Board;
import java.awt.*;
import java.awt.image.BufferedImage;

public class King extends Piece {

	public King(Board board,int col,int row,boolean isWhite) {
		super(board);
		this.row = row;
		this.col = col;
		this.x = col * board.squareSize;
	    this.y = row * board.squareSize;
		this.name ="King";
		this.isWhite = isWhite;
		this.sprite = sheet.getSubimage(0,isWhite ? 0 : sheetWidth, sheetWidth,sheetWidth).getScaledInstance(board.squareSize, board.squareSize,BufferedImage.SCALE_SMOOTH );
	}
}
