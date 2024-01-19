package Interview_PPDB_OOP;

import java.util.Random;

public class Snake extends Entity implements Movable {
  private static final Random rand = new Random();

  public int size = 1;

  public Snake(int width, int height) {
    super(rand.nextInt(width), rand.nextInt(height));
  }

  @Override
  public void draw() {
    System.out.println("Snake drawn at (" + x + ", " + y + ")");
  }

  @Override
  public void move(int direction) {
    switch (direction) {
      case 0:
        moveUp();
        break;
      case 1:
        moveDown();
        break;
      case 2:
        moveLeft();
        break;
      case 3:
        moveRight();
        break;
    }
  }

  public boolean eat(Food food) {
    if (food.isEatenBy(this)) {
      setSize(getSize() + 1);
      food.reposition();
      System.out.println("Food eaten by snake. Snake size: " + getSize());
      return true;
    }
    return false;
  }

  public int getSize() {
    return size;
  }

  private void setSize(int size) {
    if (size > 0) {
      this.size = size;
    } else {
      throw new IllegalArgumentException("Size must be positive");
    }
  }

  private void moveUp() {
    setY(getY() - 1);
  }

  private void moveDown() {
    setY(getY() + 1);
  }

  private void moveLeft() {
    setX(getX() - 1);
  }

  private void moveRight() {
    setX(getX() + 1);
  }
}
