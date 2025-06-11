package com.chess.Model;

public class Knight extends Piece {
    public Knight(String name, String color, int x, int y) {
        super(name, color, x, y);
    }

    public boolean isValidMove(int currentx, int currenty, int newx, int newY, Board board, String color) {
        if (Math.abs(currentx - newx) == 2 && Math.abs(currenty - newY) == 1
         || Math.abs(currenty - newY) == 2 && Math.abs(currentx - newx) == 1) {
            Piece pieceToMove = board.getBoard()[newx][newY];
            if (pieceToMove.getName().equals(" ")) {
                return true;
            }
            if (!pieceToMove.getColor().equals(color)) {
                return true;
            }
        }
        return false;
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
