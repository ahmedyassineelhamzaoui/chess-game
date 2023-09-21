package Piece;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Board.Board;

public class Piece {

	public int row,col;
	public int x,y;
	public boolean isWhite;
	public String name;
	public int value;
	Board board;

	BufferedImage sheet;
	{
		try {
			sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pices.png"));
		}catch(Exception e) {
			e.getMessage();		
		}
	}
	protected int sheetWidth = sheet.getWidth()/6;	
	Image sprite;

	
	public Piece(Board board) {
		this.board = board;
	}

	public void paint(Graphics2D g2d) {
		g2d.drawImage(sprite,x, y, null);
	}

	public String toString() {
		return "Piece :"+name+" col"+col+"  row"+row+" X"+x+"  Y"+y;
	}
}
