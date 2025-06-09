package com.chess.Model;

import org.springframework.web.bind.annotation.GetMapping;

public class Board {

    Piece[][] board = new Piece[8][8];
    
    public void setupBoard() {
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("Pawn", "White", 1, i);
            board[6][i] = new Pawn("Pawn", "Black", 6, i);
        }

        board[0][0] = new Rook("Rook", "White", 0, 0);
        board[0][7] = new Rook("Rook", "White", 0, 7);

        board[7][0] = new Rook("Rook", "Black", 7, 0);
        board[7][7] = new Rook("Rook", "Black", 7, 7);

        board[0][1] = new Knight("Knight", "White", 0, 1);
        board[0][6] = new Knight("Knight", "White", 0, 6);

        board[7][1] = new Knight("Knight", "Black", 7, 1);
        board[7][6] = new Knight("Knight", "Black", 7, 6);

        board[0][2] = new Bishop("Bishop", "White", 0, 2);
        board[0][5] = new Bishop("Bishop", "White", 0, 5);

        board[7][2] = new Bishop("Bishop", "Black", 7, 2);
        board[7][5] = new Bishop("Bishop", "Black", 7, 5);

        board[0][3] = new Queen("Queen", "White", 0, 3);
        board[7][3] = new Queen("Queen", "Black", 7, 3);

        board[0][4] = new King("King", "White", 0, 4);
        board[7][4] = new King("King", "Black", 7, 4);
        
        for(int x =2; x < 6; x++) {
            for(int y = 0; y < 8; y++) {
                //if(board[x][y] == null) {
                board[x][y] = new Piece(" ", " ", x, y); 
                //}
            }
        }
    }
    
    public Piece[][] getBoard() {
        return board;
    }

    public void movePiece(Piece currentPosition, Piece newPosition) {
        int currentX = currentPosition.getX();
        int currentY = currentPosition.getY();
        int newX = newPosition.getX();
        int newY = newPosition.getY();

        Piece pieceToMove = board[currentX][currentY];

        if (board[newX][newY] != null) {
            System.out.println("Target position is occupied by: " + board[newX][newY].getName() + " " + board[newX][newY].getColor());
        }

        pieceToMove.setX(newX);
        pieceToMove.setY(newY);

        board[newX][newY] = pieceToMove;
        board[currentX][currentY] = new Piece(" ", " ", currentX, currentY);
    }
}
