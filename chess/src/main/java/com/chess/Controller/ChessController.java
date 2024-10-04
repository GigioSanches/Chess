package com.chess.Controller;

import com.chess.Model.Piece;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:35773") // FRONTEND
@RestController
public class ChessController {


    @GetMapping("/api/chessboard")
    public Piece[][] showBoard() {
        Piece[][] board = new Piece[8][8];
        Piece.setupBoard(board);
        return board;
    }
    @GetMapping("/test")
    public String testEndpoint() {
        return "Endpoint is working!"; 
    }

}
