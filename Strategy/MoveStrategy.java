package Strategy;

import snake.Model.Direction;
import snake.Model.Point;
import snake.Model.Snake;

@FunctionalInterface
public interface MoveStrategy {
    Point computeNextPosition(Snake snake, Direction current);
}
