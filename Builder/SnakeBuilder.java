package Builder;

import java.util.ArrayDeque;
import java.util.Deque;

import snake.Model.Direction;
import snake.Model.Point;
import snake.Model.Snake;

public class SnakeBuilder {
    private Point Start = new Point(5,5);
    private int length = 4;
    private Direction direction = Direction.RIGHT;

    public SnakeBuilder start(Point p)       { Start = p; return this; }
    public SnakeBuilder length(int l)        { length = l; return this; }
    public SnakeBuilder direction(Direction d){ direction = d;  return this; }

    public Snake build() {
        Deque<Point> body = new ArrayDeque<>();
        for (int i = 0; i < length; i++)
            body.addFirst(new Point(Start.x() - i * direction.dx, Start.y() - i * direction.dy));
        return new Snake(body, direction);
    }
}
