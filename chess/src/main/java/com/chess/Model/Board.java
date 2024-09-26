package com.chess.Model;

public class Board {
    public int number;
    public String Letter;
    public Boolean Color;


    // Validation for valid position
    public boolean isEmpty(String[][] Board, int number, char Letter) {
        int line = Letter - 'A';
        int column = number;
        return Board[line][column] == null;
    }

    public static void showBoard(Board[][] Board) {
        for (int x = 0; x <= Board.length; x++) {
            for (int y = 0; y <= Board.length; y++) {
                System.out.println(Board[x][y]);
            }
            System.out.println();
        }
    }

}