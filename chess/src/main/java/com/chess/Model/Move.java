package com.chess.Model;

public class Move {
    public boolean isValid(Piece piece, int newX, int newY) {
        if(piece.name.equals("Pawn")) {
            return true;
        } 
        else {
            return false;
        }
    }

}
