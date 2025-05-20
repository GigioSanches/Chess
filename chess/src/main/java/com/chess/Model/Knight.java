package com.chess.Model;

public class Knight extends Piece {
    public Knight(String name, String color, int x, int y) {
        super(name, color, x, y);
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
