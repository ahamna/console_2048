package co.game2048.driver;

import co.game2048.game.Game;

public class BottomMove implements MoveStrategy {

	@Override
	public void execute(Game game) {
		
		int [][] board = game.getBoard();
		
		int n = board.length;
		
		for(int i=n-1;i>0;i--) {
			
			
		}

	}

}
