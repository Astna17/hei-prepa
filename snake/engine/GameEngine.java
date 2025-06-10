package snake.engine;

import Builder.SnakeBuilder;
import Factory.FoodFactory;
import State.GameState;
import State.MenuState;
import Strategy.ManualMoveStrategy;
import Strategy.MoveStrategy;
import snake.Model.Direction;
import snake.Model.Point;
import snake.Model.Snake;

public class GameEngine implements Runnable {
    private static final int SIZE = 10;
    private static final long TICK_MS = 250;

    private GameState   state;
    private Snake       snake;
    private Point       food;
    private int         score;
    private boolean     running = true;

    private final MoveStrategy moveStrategy = new ManualMoveStrategy();

    public GameEngine() { reset(); }

    public int size() { 
        return SIZE; 
    }
    public Snake getSnake() { 
        return snake; 
    }
    public Point getFood() { 
        return food; 
    }
    public void  setFood(Point point) { 
        food = point;
     }
    public int   getScore() { 
        return score;
     }
    public void  incScore()  { 
        score++; 
    }
    public MoveStrategy getMoveStrategy() { return moveStrategy; }

    public void setState(GameState s) { state = s; }
    public void stop()                { running = false; }

    public void reset() {
        snake = new SnakeBuilder().length(3).direction(Direction.RIGHT).build();
        food  = FoodFactory.nextFood(SIZE, snake);
        score = 0;
        state = new MenuState();
    }

    @Override public void run() {
        while (running) {
            state.render(this);
            state.tick(this);
            try { Thread.sleep(TICK_MS); } catch (InterruptedException ignored) {}
            clearConsole();
        }
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    }
}
