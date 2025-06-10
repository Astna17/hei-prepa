import java.util.Deque;

public class Snake {
    private final Deque<Point> body;
    private Direction directions;
    private boolean growNext ;

    public Snake (Deque<Point>body, Direction directions) {
        this.body = body;
        this.directions = directions;
        this.growNext = false;
    }

    public Point head() {
        return body.peekFirst();
    }

    public Deque <Point> body() {
        return body;
    }

    public Direction direction() {
        return directions;
    }

    public void setDirection(Direction direction) {
        directions = direction;
    }

    public boolean occupies(Point point) {
        return body.contains(point);
    }

    public boolean moveTo(Point next) {
        body.addFirst(next);
        if (!growNext) {
            body.removeLast();
            growNext = false;
            return body.stream().skip(1).anyMatch(next::equals);
        }
        return growNext;
    }
}
