package com.chess.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chess.Model.Bishop;
import com.chess.Model.Board;
import com.chess.Model.Knight;
import com.chess.Model.Move;
import com.chess.Model.Pawn;
import com.chess.Model.Piece;
import com.chess.Model.Rook;

@Service
public class ChessService {

    Board board = new Board();
    List<Piece> capturedPieces = new ArrayList<>();

    public ChessService() {
        board.setupBoard();
    }

    public Piece[][] getChessBoard() {
        return board.getBoard();
    }

    public void move(Move move) {
        Piece currentPosition = move.getCurrentPosition();
        Piece newPosition = move.getNewPosition();
        Piece pieceToMove = board.getBoard()[currentPosition.getX()][currentPosition.getY()];

        if (pieceToMove.getName().equals("Pawn")) {
            Pawn pawn = (Pawn) pieceToMove;
            if (!pawn.isValidMove(currentPosition.getX(),currentPosition.getY(),newPosition.getX(),newPosition.getY(), board, pieceToMove.getColor())) {
                throw new IllegalArgumentException("Invalid move for Pawn from (" + currentPosition.getX() + ", " + currentPosition.getY() + ") to (" + newPosition.getX() + ", " + newPosition.getY() + ")");
            }
        }

         if (pieceToMove.getName().equals("Bishop")) {
            Bishop bishop = (Bishop) pieceToMove;
            if (!bishop.isValidMove(currentPosition.getX(),currentPosition.getY(),newPosition.getX(),newPosition.getY(), board, pieceToMove.getColor())) {
                throw new IllegalArgumentException("Invalid move for Bishop from (" + currentPosition.getX() + ", " + currentPosition.getY() + ") to (" + newPosition.getX() + ", " + newPosition.getY() + ")");
            }
        }

        if (pieceToMove.getName().equals("Rook")) {
            Rook rook = (Rook) pieceToMove;
            if (!rook.isValidMove(currentPosition.getX(),currentPosition.getY(),newPosition.getX(),newPosition.getY(), board,pieceToMove.getColor())) {
                throw new IllegalArgumentException("Invalid move for Rook from (" + currentPosition.getX() + ", " + currentPosition.getY() + ") to (" + newPosition.getX() + ", " + newPosition.getY() + ")");
            }   
        }

        if (pieceToMove.getName().equals("Knight")) {
            Knight knight = (Knight) pieceToMove;
            if (!knight.isValidMove(currentPosition.getX(), currentPosition.getY(), newPosition.getX(), newPosition.getY(), board, pieceToMove.getColor())) {
                throw new IllegalArgumentException("Invalid move for Knight from (" + currentPosition.getX() + ", " + currentPosition.getY() + ") to (" + newPosition.getX() + ", " + newPosition.getY() + ")");
            }
        }
       

        if (!board.getBoard()[newPosition.getX()][newPosition.getY()].getName().equals(" ")) {
            addCapturedPiece(board.getBoard()[newPosition.getX()][newPosition.getY()]);
        }

        board.movePiece(currentPosition, newPosition);
    }
    
    public List<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public void addCapturedPiece(Piece piece) {
        capturedPieces.add(piece);
    }
    
    public void resetBoard() {
        board.setupBoard();
        capturedPieces.clear();
    }
}
