package com.chess.Controller;

import com.chess.Model.Board;
import com.chess.Model.Move;
import com.chess.Model.Piece;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200") // FRONTEND
@RestController
public class ChessController {

    Board board = new Board();

    public ChessController() {
        board.setupBoard();
    }

    @GetMapping("/api/chessboard")
    public Piece[][] getChessBoard() {
        //board.setupBoard();
        return board.getBoard();
    }

    @PostMapping("/api/Move")
    public void Move(@RequestBody Move move) {

        Piece currentPosition = move.getCurrentPosition();
        Piece newPosition = move.getNewPosition();

        if(board.getBoard()[newPosition.getX()][newPosition.getY()].getName() != " ") {
            addCapturedPiece(board.getBoard()[newPosition.getX()][newPosition.getY()]);
        }

        board.movePiece(currentPosition, newPosition);

        System.out.println("Peça atual: " + currentPosition.getName() + " " +
                       currentPosition.getColor() + " (" + currentPosition.getX() + ", " + currentPosition.getY() + ")");
        System.out.println("Nova posição: (" + newPosition.getX() + ", " + newPosition.getY() + ")");            
    }


    private List<Piece> capturedPieces = new ArrayList<>();
    
    public void addCapturedPiece(Piece piece) {
        capturedPieces.add(piece);
    }

    @GetMapping("api/fetchCapturedPieces")
    private List<Piece> getCapturedPieces() {
        return capturedPieces;
    }
    
    @PostMapping("/api/Reset")
    public void resetBoard() {
        board.setupBoard();
        capturedPieces.clear();
        System.out.println("Tabuleiro reiniciado.");
    }

}
