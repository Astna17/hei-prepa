package State;

import snake.engine.GameEngine;

public class GameOverState implements GameState {
    @Override 
    public void tick(GameEngine game) { 

     }

    @Override 
    public void render(GameEngine game) {
        System.out.printf("GAME OVER  Score: %d%n", game.getScore());
        System.out.println("R = rejouer | Q = quitter");
        try {
            int c = System.in.read();
            if (c == 'R' || c == 'r') game.reset();
            else                       game.stop();
        } catch (Exception ignored) {}
    }
}
