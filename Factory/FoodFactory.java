package Factory;

import java.security.SecureRandom;

import snake.Model.Point;
import snake.Model.Snake;

public final class FoodFactory {
    private static final SecureRandom RNG = new SecureRandom();

    private FoodFactory() { }

    public static Point nextFood(int size, Snake snake) {
        Point p;
        do {
            p = new Point(RNG.nextInt(size), RNG.nextInt(size));
        } while (snake.occupies(p));
        return p;
    }
}

