package com.chess.Controller;

import com.chess.Model.Board;
import com.chess.Model.Move;
import com.chess.Model.Piece;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200") // FRONTEND
@RestController
public class ChessController {
    @GetMapping("/api/chessboard")
    public Piece[][] getChessBoard() {
        Board board = new Board();
        board.setupBoard();
        return board.showBoard();
    }

    @PostMapping("/api/ExibePosicao")
    public void ExibePosicao(@RequestBody Move move) {

        Piece currentPosition = move.getCurrentPosition();
        Piece newPosition = move.getNewPosition();

        System.out.println("Peça atual: " + currentPosition.getName() + " " +
                       currentPosition.getColor() + " (" + currentPosition.getX() + ", " + currentPosition.getY() + ")");
        System.out.println("Nova posição: (" + newPosition.getX() + ", " + newPosition.getY() + ")");    }

}
