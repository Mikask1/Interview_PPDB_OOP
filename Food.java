package Interview_PPDB_OOP;

import java.util.Random;

public class Food extends Entity {
  private static final Random rand = new Random();
  private int width, height;

  public Food(int width, int height) {
    super(rand.nextInt(width), rand.nextInt(height));
    this.width = width;
    this.height = height;
  }

  @Override
  public void draw() {
    System.out.println("Food drawn at (" + x + ", " + y + ")");
  }

  public void reposition() {
    x = rand.nextInt(width);
    y = rand.nextInt(height);
    draw();
  }

  public boolean isEatenBy(Entity entity) {
    return x == entity.getX() && y == entity.getY();
  }
}