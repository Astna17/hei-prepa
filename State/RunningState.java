package State;

import Factory.FoodFactory;
import Strategy.MoveStrategy;
import snake.Model.Point;
import snake.Model.Snake;
import snake.engine.GameEngine;

public class RunningState implements GameState {
    @Override 
    public void tick(GameEngine game) {
        Snake        snake   = game.getSnake();
        MoveStrategy move  = game.getMoveStrategy();
        Point        next = move.computeNextPosition(snake, snake.direction());

        
        if (next.outOfBounds(game.size()) || snake.moveTo(next)) {
            game.setState(new GameOverState());
            return;
        }
        
        if (next.equals(game.getFood())) {
           // snake.scheduleGrowth();
            game.incScore();
            game.setFood(FoodFactory.nextFood(game.size(), snake));
        }
    }

    @Override 
    public void render(GameEngine game) {
        int   n    = game.size();
        Point food = game.getFood();

        for (int y = 0; y < n; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < n; x++) {
                Point point = new Point(x, y);
                if (point.equals(food))                  row.append('@');
                else if (game.getSnake().occupies(point))   row.append('*');
                else                                  row.append('.');
                row.append(' ');
            }
            System.out.println(row);
        }
        System.out.println("Score: " + game.getScore());
    }
}
