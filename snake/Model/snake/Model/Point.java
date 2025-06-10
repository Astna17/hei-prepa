package snake.Model;
public record Point(int x, int y) {
    public boolean outOfBounds(int size) {
        return x < 0 || x >= size || y < 0 || y >= size;
    }
}