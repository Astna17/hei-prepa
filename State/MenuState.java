package State;

import snake.engine.GameEngine;

public class MenuState implements GameState {
    @Override public void tick(GameEngine game) { game.setState(new RunningState()); }

    @Override public void render(GameEngine game) {
        System.out.println("=== HEI SNAKE ===");
        System.out.println("Appuyez sur Entrée pour démarrer…");
        try { System.in.read(); } catch (Exception ignored) {}
    }
}
