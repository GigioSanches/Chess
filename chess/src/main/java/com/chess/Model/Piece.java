package com.chess.Model;

public class Piece {
    public String Name;
    public char Color;
    public int line;
    public int column;

    public Piece(char pieceColor, String pieceName, int pieceLine, int pieceColumn) 
    {
        this.Name   = pieceName;
        this.Color  = pieceColor;
        this.line   = pieceLine;
        this.column = pieceColumn;
    }

    public char getColor() {
        return this.Color;
    }

    public String getName() {
        return this.Name;
    }

    public static void setupBoard(Piece[][] board) {

        board[0][0] = new Piece('W',"Rook",0,0);
        board[0][1] = new Piece('W',"Knight",0,1);
        board[0][2] = new Piece('W',"Bishop",0,2);
        board[0][3] = new Piece('W',"Queen",0,3);
        board[0][4] = new Piece('W',"King",0,4);
        board[0][5] = new Piece('W',"Bishop",0,5);
        board[0][6] = new Piece('W',"Knight",0,6);
        board[0][7] = new Piece('W',"Rook",0,7);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Piece('W',"Pawn",1,i);
        }

        board[7][0] = new Piece('B',"Rook",7,0);
        board[7][1] = new Piece('B',"Knight",7,1);
        board[7][2] = new Piece('B',"Bishop",7,2);
        board[7][3] = new Piece('B',"Queen",7,3);
        board[7][4] = new Piece('B',"King",7,4);
        board[7][5] = new Piece('B',"Bishop",7,5);
        board[7][6] = new Piece('B',"Knight",7,6);
        board[7][7] = new Piece('B',"Rook",7,7);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Piece('B',"Pawn",7,i);
        }

        showBoard(board);

    }

    public static void showBoard(Piece[][] board){
        for (int x = 0; x < board.length; x++ ) {
            for (int y = 0; y < board[x].length;y++){
                if(board[x][y] != null){
                    System.out.print(board[x][y].getName().charAt(0) + "" + board[x][y].getColor() + " ");
                }
                else{
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

}