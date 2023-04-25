package co.game2048.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	private int board[][];
	private List<Integer> vaccentCells;
	private Random random;
	private boolean win = false;
	private boolean loss = false;
	public Game (){
		random = new Random();
		board = new int [4][4];
		vaccentCells = new ArrayList<Integer>();
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				vaccentCells.add(i*4+j);
			}
		}
		int rand1 = random.nextInt(vaccentCells.size());
		board[rand1/4][rand1%4] = 2 * (random.nextInt(2)+1);
		vaccentCells.remove(rand1);		
		int rand2 = random.nextInt(vaccentCells.size());
		board[rand2/4][rand2%4] = 2 * (random.nextInt(2)+1);
		vaccentCells.remove(rand2);
	}
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
	public List<Integer> getVaccentCells() {
		return vaccentCells;
	}
	public void setVaccentCells(List<Integer> vaccentCells) {
		this.vaccentCells = vaccentCells;
	}
	public Random getRandom() {
		return random;
	}
	public void setRandom(Random random) {
		this.random = random;
	}
	public void printBoard() {
		int n = board.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j] == 0) {
					System.out.print("- ");
				}
				else {
					System.out.print(board[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	public boolean win() {
		return this.win;
	}
	public boolean loss() {
		return this.loss;
	}
}
