package com.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chess.Model.Piece;

@SpringBootApplication(scanBasePackages = "com.chess")
public class ChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);
		System.out.println("Let's start the chess");
		Piece[][] board;
		board = new Piece[8][8];
		Piece.setupBoard(board);      
	}
}