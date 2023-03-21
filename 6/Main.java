import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
      // 1.
      // Карта с каким-то размером nxm.
      // На ней можно создать роботов, указывая начальное положение.
      // Если начальное положение некорректное ИЛИ эта позиция занята другим роботом, то кидаем исключение.
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
      // help

    System.out.println("Введите команду для создания карты:");
    RobotMap map = null;
    while (true) {
      String command = sc.nextLine();
      if (command.startsWith("create-map")) {
        String[] split = command.split(" ");
        String[] arguments = Arrays.copyOfRange(split, 1, split.length);

        try {
          map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
          System.out.println("Карта создана!");
          break;
        } catch (IllegalArgumentException e) {
          System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." + " Попробуйте еще раз");
        }
      } else {
        System.out.println("Команда не найдена. Попробуйте еще раз");
      }
    }

    Help help = new Help();

    List<CommandHandler> handlers = List.of(
      new ChangeDirectionCommandHandler(),
      new CreateRobotCommandHandler(),
      new MoveRobotCommandHandler(),
      help
    );
    CommandManager commandManager = new CommandManager(map, handlers);

    System.out.println("ИГРАЕМ...");
    help.viewCommand(handlers);
    while (true) {
      String command = sc.nextLine();
      commandManager.handleCommand(command);
    }
  }
}