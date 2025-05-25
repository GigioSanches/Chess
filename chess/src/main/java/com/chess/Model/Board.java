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

        board[0][4] = new King("O", "White", 0, 4);
        board[7][4] = new King("O", "Black", 7, 4);
        
        for(int x =0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if(board[x][y] == null) {
                    board[x][y] = new Piece(" ", " ", x, y); 
                }
            }
        }
    }
    
    public Piece[][] showBoard() {
        setupBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    System.out.print(" " + board[i][j].name.substring(0,1) + " ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
        return board;
    }

    
    public void ExibePosicao(Piece piece) {
        System.out.println("parasasa");
    }
}
