package com.chess.Model;

public class Move {

    public Piece currentPosition;
    public Piece newPosition;

    public Move(Piece currentPosition, Piece newPosition) {
        this.currentPosition = currentPosition;
        this.newPosition = newPosition;
    }

    public Piece getCurrentPosition() {
        return currentPosition;
    }

    public Piece getNewPosition() {
        return newPosition;
    }

    public void setCurrentPosition(Piece currentPosition) {
        this.currentPosition = currentPosition;
    }
    
    public void setNewPosition(Piece newPosition) {
        this.newPosition = newPosition;
    }

    public boolean isValid(Piece piece, int newX, int newY) {
        if(piece.name.equals("Pawn")) {
            return true;
        } 
        else {
            return false;
        }
    }

}
