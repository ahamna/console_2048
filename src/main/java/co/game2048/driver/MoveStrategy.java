package co.game2048.driver;

import co.game2048.game.Game;

public interface MoveStrategy {
	void execute(Game game);
}
