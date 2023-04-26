package co.game2048.driver;

import java.util.LinkedList;
import java.util.Queue;

import co.game2048.game.Game;

public class TopMove implements MoveStrategy {

	@Override
	public void execute(Game game) {

		int[][] board = game.getBoard();
		int n = board.length;
		for (int col = 0; col < n; col++) {
			Queue<Integer> q = new LinkedList<Integer>();
			for (int row = 0; row < n; row++) {
				if (board[row][col] != 0) {
					q.add(board[row][col]);
					board[row][col] = 0;
				}
			}
			int row = 0;
			while (!q.isEmpty()) {
				int x = q.poll();
				board[row][col] = x;
				if (q.isEmpty())
					break;
				if (x == q.peek()) {
					board[row][col] += q.poll();
				}
				row++;
			}

		}
	}

}
