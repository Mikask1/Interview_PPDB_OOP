package Interview_PPDB_OOP;

import java.util.Random;

public class SnakeGame {
  private Snake snake;
  private Food food;
  private static final int WIDTH = 10;
  private static final int HEIGHT = 10;
  private int score;

  public static void main(String[] args) {
    SnakeGame game = new SnakeGame();
    game.createGameEntities();
    game.playGame();
  }

  public void createGameEntities() {
    snake = new Snake(WIDTH, HEIGHT);
    food = new Food(WIDTH, HEIGHT);
    score = 0;
  }

  private boolean isSnakeOutOfBounds() {
    int snakeX = snake.getX();
    int snakeY = snake.getY();
    return snakeX < 0 || snakeX >= WIDTH || snakeY < 0 || snakeY >= HEIGHT;
  }

  public void playGame() {
    food.draw();
    while (true) {
      snake.move(new Random().nextInt(4));
      snake.draw();
      if (isSnakeOutOfBounds()) {
        System.out.println("Snake is out of bounds!");
        break;
      }

      if (snake.eat(food)) {
        score++;
        food.reposition();
      }
    }

    System.out.println("Final Score: " + score);
  }
}
