public enum Direction {
    UP(0,-1),
    DOWN(0,1),
    LEFT(-1,0),
    RIGHT(1,0);

    public final int dx, dy ;
    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Point next (Point point) {
        return new Point(point.x() + dx, point.y() + dy);
    }

    public boolean isOpposite(Direction direction) {
        return dx + direction.dx == 0 && dy + direction.dy == 0;
    }

    public static Direction fromKey(char keyboard) {
        return switch(Character.toUpperCase(keyboard)) {
            case 'W' -> UP; 
            case 'S' -> DOWN;
            case 'A' -> LEFT;
            case 'D' -> RIGHT;
            default -> null;
        };
    }
}
