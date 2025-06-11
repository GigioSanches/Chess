package com.chess.Model;

public class Pawn extends Piece {

    public Pawn(String name, String color, int x, int y) {
        super(name, color, x, y);
    }

    public boolean isValidMove(int currentx, int currenty, int newx, int newY, Board board, String color) {
        if(color.equals("White")) {
            if(currentx == 1 && newx <= 3 && newx > 1 && board.getBoard()[newx][newY].getName().equals(" ") && currenty == newY) {
                return true;
            }
            if(currentx != 1 && newx == currentx + 1 && board.getBoard()[newx][newY].getName().equals(" ") && currenty == newY) {
                return true;
            }
            if (newx == currentx + 1 && (newY == currenty - 1 || newY == currenty + 1) && !board.getBoard()[newx][newY].getName().equals(" ") && !board.getBoard()[newx][newY].getColor().equals(color)) {
                return true;
            }
        }
        else {
            if(currentx == 6 && newx >= 4 && newx < 6 && board.getBoard()[newx][newY].getName().equals(" ") && currenty == newY) {
                return true;
            }
            if(currentx != 6 && newx == currentx - 1 && board.getBoard()[newx][newY].getName().equals(" ") && currenty == newY) {
                return true;
            }
            if (newx == currentx - 1 && (newY == currenty - 1 || newY == currenty + 1) && !board.getBoard()[newx][newY].getName().equals(" ") && !board.getBoard()[newx][newY].getColor().equals(color)) {
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
