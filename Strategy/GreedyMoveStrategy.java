package Strategy;

import snake.Model.Direction;
import snake.Model.Point;
import snake.Model.Snake;

public class GreedyMoveStrategy implements MoveStrategy {
    @Override 
    public Point computeNextPosition(Snake snake, Direction current) {
        return current.next(snake.head());
    }
}

