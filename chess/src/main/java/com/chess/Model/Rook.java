package com.chess.Model;

public class Rook extends Piece{

    public Rook(String name, String color, int x, int y) {
        super(name, color, x, y);
    }

    public boolean isValidMove(int currentx, int currenty, int newx, int newY, Board board, String color) {

        if (currentx != newx && currenty != newY) {
            return false;
        }

        if (currenty == newY) {
            int start = Math.min(currenty,newY);
            int end   = Math.max(currenty,newY);

            for (int i = start + 1; i < end; i++) {
                if(board.getBoard()[currentx][i].getName().equals(" ")){
                    return true;
                }
            }
        }

        if (currentx == newx) {
            int start = Math.min(currentx,newx);
            int end   = Math.max(currentx,newx);

            for (int i = start + 1; i < end; i++) {
                if(board.getBoard()[i][y].getName().equals(" ")){
                    return true;
                }
            }
        }

        Piece pieceToMove = board.getBoard()[newx][newY];

        if(pieceToMove.getName().equals(" ")) {
            return true;
        }

        if(!pieceToMove.getColor().equals(color)) {
            return true;
        }
        return false; // Invalid move
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
