package com.chess.Controller;

import com.chess.Model.Board;
import com.chess.Model.Move;
import com.chess.Model.Piece;
import com.chess.Services.ChessService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ChessController {

    @Autowired
    ChessService chessService = new ChessService();

    Board board = new Board();

    @GetMapping("/api/chessboard")
    public Piece[][] getChessBoard() {
        return chessService.getChessBoard();
    }

    @PostMapping("/api/Move")
    public void Move(@RequestBody Move move) {
        chessService.move(move);
    }

    @GetMapping("api/fetchCapturedPieces")
    private List<Piece> getCapturedPieces() {
        return chessService.getCapturedPieces();
    }
    
    @PostMapping("/api/Reset")
    public void resetBoard() {
        chessService.resetBoard();
    }

}
