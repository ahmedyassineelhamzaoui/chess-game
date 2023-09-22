package Board;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

import Piece.Bishop;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;

public class Board extends JPanel {

	public int squareSize = 70;
	int cols =8;
	int rows =8;
	ArrayList<Piece> piecsList = new ArrayList<>();
	Input i = new Input(this);

	public Board() {
		setPreferredSize(new Dimension(cols*squareSize,rows*squareSize));
		this.addMouseListener(i);
		this.addMouseMotionListener(i);
		addPieces();
	}
	public Piece selectedPiece;

	public Piece getPieceAt(int col,int row) {
		
		for(Piece p:piecsList) {
			if(p.col == col && p.row == row) {
				return p;
			}
		}
		return null;
	}
	public void addPieces() {
		// black pieces
		piecsList.add(new Knight(this,1,0,false));
		piecsList.add(new Knight(this,6,0,false));
		piecsList.add(new Bishop(this,2,0,false));
		piecsList.add(new Bishop(this,5,0,false));
		piecsList.add(new King(this,4,0,false));
		piecsList.add(new Rook(this,0,0,false));
		piecsList.add(new Rook(this,7,0,false));
		piecsList.add(new Queen(this,3,0,false));
		piecsList.add(new Pawn(this,0,1,false));
		piecsList.add(new Pawn(this,1,1,false));
		piecsList.add(new Pawn(this,2,1,false));
		piecsList.add(new Pawn(this,3,1,false));
		piecsList.add(new Pawn(this,4,1,false));
		piecsList.add(new Pawn(this,5,1,false));
		piecsList.add(new Pawn(this,6,1,false));
		piecsList.add(new Pawn(this,7,1,false));
		// white pieces
		piecsList.add(new Knight(this,1,7,true));
		piecsList.add(new Knight(this,6,7,true));
		piecsList.add(new Bishop(this,2,7,true));
		piecsList.add(new Bishop(this,5,7,true));
		piecsList.add(new King(this,4,7,true));
		piecsList.add(new Rook(this,0,7,true));
		piecsList.add(new Rook(this,7,7,true));
		piecsList.add(new Queen(this,3,7,true));
		piecsList.add(new Pawn(this,0,6,true));
		piecsList.add(new Pawn(this,1,6,true));
		piecsList.add(new Pawn(this,2,6,true));
		piecsList.add(new Pawn(this,3,6,true));
		piecsList.add(new Pawn(this,4,6,true));
		piecsList.add(new Pawn(this,5,6,true));
		piecsList.add(new Pawn(this,6,6,true));
		piecsList.add(new Pawn(this,7,6,true));
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g ;
		for(int r=0;r<rows;r++) {
			for(int c=0;c<cols;c++) {
				g2d.setColor((c+r)%2 == 0 ? new Color(121,172,120) : new Color(208,231,210) );
				g2d.fillRect(c*squareSize,r*squareSize,squareSize,squareSize);
			}
		}
		for(Piece p:piecsList) {
			p.paint(g2d);
		}
	}
	
	public boolean isValidMove(Move m) {	
		if(sameColor(m.piece,m.capture)) {
			return false;
		}    
		if(m.piece.name =="knight") {
			
			if(Math.sqrt(Math.pow(m.piece.col - m.newcol, 2) + Math.pow(m.piece.row - m.newrow, 2)) == Math.sqrt(5)) {
				return true;
			}
			return false;
			
		}else if(m.piece.name ==  "Bishop") {
			
			int dx = m.newcol - m.piece.col;
			int dy = m.newrow - m.piece.row;
			if(Math.abs(m.piece.col - m.newcol) - Math.abs(m.piece.row - m.newrow) == 0) {
				for(int i=1; i<Math.max(Math.abs(dx),Math.abs(dy)); i++) {
					  int x = m.piece.col + dx/Math.abs(dx)*i;
					  int y = m.piece.row + dy/Math.abs(dy)*i;
					  if(getPieceAt(x,y) != null) {
					    return false;
					  }
				}
				return true;
			}
			return false;
			
		}else if(m.piece.name ==  "King") {
			if(Math.abs(m.piece.col - m.newcol) > 1 || Math.abs(m.piece.row - m.newrow) >1) {
				return false;
			}
			return true;
		}else if(m.piece.name == "Rook") {

			  int dx = m.newcol - m.piece.col;
			  int dy = m.newrow - m.piece.row;

			  if(dx == 0 || dy == 0) { // vertical or horizontal move

			    if(dx != 0) { // horizontal move
			      for(int i=1; i<Math.abs(dx); i++) {
			        int x = m.piece.col + dx/Math.abs(dx)*i; 
			        if(getPieceAt(x, m.piece.row) != null) {
			          return false;
			        }
			      }  
			    }

			    if(dy != 0) { // vertical move
			      for(int i=1; i<Math.abs(dy); i++) {
			        int y = m.piece.row + dy/Math.abs(dy)*i;
			        if(getPieceAt(m.piece.col, y) != null) {  
			          return false;
			        }
			      }
			    }

			    return true;

			  }

			  return false;
		}else if(m.piece.name.equals("Pawn")) {

			if(!m.piece.isWhite) {
				if(m.piece.row == 1) {
					if(m.newrow <= 3) {
						return true;
					}return false;
				}else {					
					if(m.newrow - m.piece.row > 1 || m.newrow - m.piece.row <= 0) {
						return false;
					}else if((getPieceAt(m.newcol, m.newrow) != null && getPieceAt(m.piece.col , m.piece.row+1) == getPieceAt(m.newcol, m.newrow)) || (getPieceAt(m.newcol, m.newrow) == null && m.piece.col != m.newcol) ) {
						return false;
					}
					return true;
				}
			}else {
				if(m.piece.row == 6) {
					if(m.newrow > 3) {
						return true;
					}return false;
				}else {					
					if(m.piece.row - m.newrow > 1 ||  m.piece.row - m.newrow <= 0) {
						return false;
					}else if((getPieceAt(m.newcol, m.newrow) != null && getPieceAt(m.piece.col , m.piece.row) == getPieceAt(m.newcol, m.newrow+1)) || (getPieceAt(m.newcol, m.newrow) == null && m.piece.col != m.newcol) ) {
						return false;
					}
					return true;
				}
			}
			
		}else {
			System.out.println("Queen");
		}             
		return true;
	}
	public boolean sameColor(Piece p1,Piece p2) {
		if(p1 == null || p2 == null) {
			return false;
		}
		return p1.isWhite == p2.isWhite;
	}
	public void makeMove(Move m) {
			m.piece.col = m.newcol;
			m.piece.row = m.newrow;
			m.piece.x   = m.newcol * squareSize;
			m.piece.y   = m.newrow * squareSize;
			capture(m);
	}
	public void capture(Move m) {
		piecsList.remove(m.capture);
	}
	

}
