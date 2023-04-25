package co.game2048.driver;

import java.util.Scanner;

import co.game2048.game.Game;

public class GameDriver {
	Game game;
	BottomMove bottomMove;
	TopMove topMove;
	LeftMove leftMove;
	RightMove rightMove;
	Scanner scanner;
	public GameDriver() {
		game = new Game();
		bottomMove = new BottomMove();
		topMove = new TopMove();
		leftMove = new LeftMove();
		rightMove = new RightMove();
		scanner = new Scanner(System.in);
	}
	
	public void start(){
		while(!loss() || !win()) {
			printBoard();
			MoveStrategy move = getNextMove();
			move.execute(game);
		}
		if(win()) {
			System.out.println("Congratulations!!!");
		}else {
			System.out.println("Game Over");
		}
	}
	
	private MoveStrategy getNextMove() {
		System.out.println("Enter Move:");
		int move = scanner.nextInt();
		switch (move) {
		case 0:
			return new LeftMove();
		case 1:
			return new RightMove();
		case 2:
			return new TopMove();
		case 3:
			return new BottomMove();
		default:
			System.out.println("Invalid Move!");
			return getNextMove();
		}
	}

	private boolean win() {
		return game.win();
	}

	private boolean loss() {
		return game.loss();
	}

	void printBoard() {
		this.game.printBoard();
	}
}
