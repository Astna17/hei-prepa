package Strategy;

import java.util.Scanner;

import snake.Model.Direction;
import snake.Model.Point;
import snake.Model.Snake;

public class ManualMoveStrategy implements MoveStrategy {
    private final Scanner in = new Scanner(System.in);

    @Override 
    public Point computeNextPosition(Snake snake, Direction current) {
        System.out.print("WASD (vide = continuer) : ");
        String line = in.nextLine().trim();
        Direction d = line.isEmpty() ? current : Direction.fromKey(line.charAt(0));
        if (d == null || d.isOpposite(current)) d = current; 
        snake.setDirection(d);
        return d.next(snake.head());
    }
}
