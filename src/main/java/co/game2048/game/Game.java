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
		int cell = vaccentCells.get(rand1);
		board[cell/4][cell%4] = 2 * (random.nextInt(2)+1);
		vaccentCells.remove(Integer.valueOf(cell));		
		int rand2 = random.nextInt(vaccentCells.size());
		cell = vaccentCells.get(rand2);
		board[cell/4][cell%4] = 2 * (random.nextInt(2)+1);
		vaccentCells.remove(Integer.valueOf(cell));
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
	public void populateNewRandomCell() {
		if(vaccentCells.size() == 0) {
			this.loss = true;
			return;
		}
		int rand = random.nextInt(vaccentCells.size());
		int cell = vaccentCells.get(rand);
		board[cell/4][cell%4] = 2 * (random.nextInt(2)+1);
		vaccentCells.remove(Integer.valueOf(cell));
	}
	public void updateVaccentCells() {
		vaccentCells.clear();
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(board[i][j] == 0)
					vaccentCells.add(i*4+j);
			}
		}
		
	}
	public void checkWin() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(board[i][j] == 32)
					this.win = true;
			}
		}
		
	}
}
