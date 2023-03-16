import java.util.HashMap;
import java.util.Map;

public class RobotMap {
  private final int n;
  private final int m;
  private final Map<Integer, Robot> robots;

  public Robot getRobot(int id) {
    return robots.get(id);
  }

  public RobotMap(int n, int m) {
    if (n < 0 || m < 0) {
      throw new IllegalArgumentException("Недопустимые значения размера карты!");
    }
    this.n = n;
    this.m = m;
    this.robots = new HashMap<>();
  }

  public Robot createRobot(Point position) throws PositionException {
    checkPosition(position);

    Robot robot = new Robot(position);
    robots.put(robot.id, robot);
    return robot;
  }

  private void checkPosition(Point position) throws PositionException {
    if (position.getX() < 0 || position.getY() < 0 || position.getX() > n || position.getY() > m) {
      throw new PositionException("Некорректное значение точки: " + position);
    }
    if (!isFree(position)) {
      throw new PositionException("Точка " + position + " занята!");
    }
  }

  private boolean isFree(Point position) {
    return robots.values().stream()
      .map(Robot::getPosition)
      .noneMatch(position::equals);
  }

  public class Robot {
    private static int count = 0;
    private int id;
    private Point position;
    private Direction direction;

    public Robot(Point position) {
      this.id = ++count;
      this.position = position;
      this.direction = Direction.TOP;
    }

    public int getId() {
      return id;
    }

    public Point getPosition() {
      return position;
    }

    public void move() throws PositionException {
      robots.get(id);
      Point newPosition = switch (direction) {
        case TOP -> new Point(position.getX() - 1, position.getY());
        case RIGHT -> new Point(position.getX(), position.getY() + 1);
        case BOTTOM -> new Point(position.getX() + 1, position.getY());
        case LEFT -> new Point(position.getX(), position.getY() - 1);
      };
      checkPosition(newPosition);

      position = newPosition;
      System.out.printf("Позиция робота %d теперь в точке %s/\n", this.id, newPosition.toString());
    }

    public void changeDirection(Direction direction) {
      this.direction = direction;
      System.out.printf("Робот %d повернул на %s\n", this.id, this.direction);
    }

    @Override
    public String toString() {
      return String.format("[%d] %s", id, position.toString());
    }
  }

  public enum Direction {
    TOP, RIGHT, BOTTOM, LEFT
  }
}
