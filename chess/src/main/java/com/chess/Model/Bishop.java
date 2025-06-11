package com.chess.Model;

public class Bishop extends Piece{

    public Bishop(String name, String color, int x, int y) {
        super(name, color, x, y);
    }


    public boolean isValidMove(int currentx, int currenty, int newx, int newY, Board board, String color) {

        if (Math.abs(newx - currentx) != Math.abs(newY - currenty)) {
            return false;
        }
        
        int dx = (newx > currentx) ? 1 : -1;
        int dy = (newY > currenty) ? 1 : -1;
        int x = currentx + dx;
        int y = currenty + dy;

        while (x != newx && y != newY) {
            if (!board.getBoard()[x][y].getName().equals(" ")) {
                return false;
            }
            x += dx;
            y += dy;
        }

        Piece pieceToMove = board.getBoard()[newx][newY];
        if (pieceToMove.getName().equals(" ")) {
            return true;
        }
        if (!pieceToMove.getColor().equals(color)) {
            return true;
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
