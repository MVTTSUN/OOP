import java.util.Arrays;
import java.util.Scanner;

public class Main {
  // Client <-> API <-> Model
  // Client_2
  public static void main(String[] args) {
    // 1.
    // Карта с каким-то размером nxm.
    // На ней можно создать робов, указывая начальное положение.
    // Если начальное положение некорректное ИЛИ эта позиция занята другим робом, то кидаем исключение.
    // Робот имеет направление (вверх, вправо, вниз, влево). У роботов можно менять направление и передвигать их на 1 шаг вперед
    // 2.
    // Написать контроллер к этому коду, который будет выступать посредником между консолью (пользователем) и этой игрой.
    // (0,0)      ------------------            (0, m)
    // ...
    // (n, 0)    -----------------------        (n, m)

    // Robot, Map, Point

    // Домашнее задание:
    // Реализовать чтение команд с консоли и выполнить их в main методе
    // Список команд:
    // create-map 3 5 -- РЕАЛИЗОВАНО!
    // create-robot 2 7
    // move-robot id
    // change-direction id LEFT

    Scanner sc = new Scanner(System.in);
    System.out.println("Введите команду для создания карты:");
    RobotMap map = null;
    boolean isCreateMap = false;

    while (true) {
      String command = sc.nextLine();
      if (command.startsWith("create-map") && !isCreateMap) {
        isCreateMap = true;
        String[] split = command.split(" ");
        String[] arguments = Arrays.copyOfRange(split, 1, split.length);

        try {
          map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
        } catch (IllegalArgumentException e) {
          System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." + " Попробуйте еще раз");
        }
      } else if (command.startsWith("create-robot") && isCreateMap) {
        String[] split = command.split(" ");
        String[] arguments = Arrays.copyOfRange(split, 1, split.length);

        try {
          map.createRobot(new Point(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])));
        } catch (PositionException e) {
          System.out.println("При создании робота возникло исключение: " + e.getMessage() + "." + " Попробуйте еще раз");
        }
      } else if (command.startsWith("move-robot") && isCreateMap) {
        String[] split = command.split(" ");
        String[] arguments = Arrays.copyOfRange(split, 1, split.length);

        try {
          map.getRobot(Integer.parseInt(arguments[0])).move();
        } catch (PositionException e) {
          System.out.println("При перемещении робота возникло исключение: " + e.getMessage() + "." + " Попробуйте еще раз");
        }
      } else if (command.startsWith("change-direction") && isCreateMap) {
        String[] split = command.split(" ");
        String[] arguments = Arrays.copyOfRange(split, 1, split.length);

        map.getRobot(Integer.parseInt(arguments[0])).changeDirection(RobotMap.Direction.valueOf(arguments[1]));
      } else {
        System.out.println("Команда не найдена. Попробуйте еще раз");
      }
    }
  }
}
