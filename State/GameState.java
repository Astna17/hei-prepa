package State;

import snake.engine.GameEngine;

public interface GameState {
    void tick(GameEngine game);

    void render(GameEngine game);
}
