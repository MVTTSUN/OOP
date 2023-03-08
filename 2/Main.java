public class Main {
  public static void main(String[] args) {
    // Представьте, что вы пишете класс Render, который отвечает за вывод на экран текущего уровня жизней и усталости какого-то объекта.
    // (Подразумеваем, что вывод на экран - это просто печать в консоль)
    // У класса есть 1 метод, который принимает тип Object и делает следующее:
    // 1. Если object типа HasHealthPoint, то выводим его уровень жизни
    // 2. Если object типа Tiredness, то выводим его уровень усталости
    // При этом текст значения должен иметь цвет в соответствии с правилом:
    // RED(0, 24), YELLOW(25, 50), GREEN(51-100)
    // 3. Создать несколько классов:
    // 3.1 Здание. Имеет только жизни.
    // 3.2 Персонаж. Имеет и жизни, и усталость

    Building building = new Building(100, 58);
    Person person = new Person(120, 28, 30, 15);

    Render render = new Render();
    render.render(building);
    render.render(person);
  }

  static class Render {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    public void render(Object object) {
      if (object instanceof HasHealthPoint hasHealthPoint) {
        HasHealthPoint hasHealthPointUnit = (HasHealthPoint) object;

        pointsView(object, "health", hasHealthPointUnit.getCurrentHealthPoint(), hasHealthPointUnit.getMaxHealthPoint());
      }
      if (object instanceof Tiredness tiredness) {
        Tiredness tirednessUnit = (Tiredness) object;
        
        pointsView(object, "tiredness", tirednessUnit.getCurrentEnergy(), tirednessUnit.getMaxEnergy());
      }
    }

    private void pointsView(Object object, String typePoint, double currentPoint, double maxPoint) {
      double percent = 100 / maxPoint * currentPoint;

      if (percent > 50) {
        System.out.printf("%sLevel %s: %d%s\n", ANSI_GREEN, typePoint, (int) currentPoint, ANSI_RESET);
        pointsBar(percent, ANSI_GREEN_BACKGROUND);
      } else if (percent >= 25 && percent <= 50) {
        System.out.printf("%sLevel %s: %d%s\n", ANSI_YELLOW, typePoint, (int) currentPoint, ANSI_RESET);
        pointsBar(percent, ANSI_YELLOW_BACKGROUND);
      } else {
        System.out.printf("%sLevel %s: %d%s\n", ANSI_RED, typePoint, (int) currentPoint, ANSI_RESET);
        pointsBar(percent, ANSI_RED_BACKGROUND);
      }
    }

    private void pointsBar(double percent, String backgroundColor) {
      StringBuilder bar = new StringBuilder();
      int percentRound = (int) percent / 10;

      for (int i = 0; i < 10; i++) {
        if (percentRound != 0) {
          bar.append(String.format("%s%c%s", backgroundColor, '#', ANSI_RESET));
          percentRound--;
        } else {
          bar.append(String.format("%s%c%s", ANSI_WHITE_BACKGROUND, '-', ANSI_RESET));
        }
      }
      System.out.println(bar);
    }
  }

  interface HasHealthPoint {
    double getMaxHealthPoint();
    double getCurrentHealthPoint();
  }

  interface Tiredness {
    double getMaxEnergy();
    double getCurrentEnergy();
  }

  static class Building implements HasHealthPoint {
    private final double maxHealthPoint;
    private double currentHealthPoint;

    public Building(double maxHealthPoint, double currentHealthPoint) {
      this.maxHealthPoint = maxHealthPoint;
      this.currentHealthPoint = currentHealthPoint;
    }

    @Override
    public double getMaxHealthPoint() {
      return maxHealthPoint;
    }

    @Override
    public double getCurrentHealthPoint() {
      return currentHealthPoint;
    }
  }

  static class Person implements HasHealthPoint, Tiredness {
    private final double maxHealthPoint;
    private double currentHealthPoint;
    private final double maxTiredness;
    private double currentTiredness;

    public Person(double maxHealthPoint, double currentHealthPoint, double maxTiredness, double currentTiredness) {
      this.maxHealthPoint = maxHealthPoint;
      this.currentHealthPoint = currentHealthPoint;
      this.maxTiredness = maxTiredness;
      this.currentTiredness = currentTiredness;
    }

    @Override
    public double getMaxHealthPoint() {
      return maxHealthPoint;
    }

    @Override
    public double getCurrentHealthPoint() {
      return currentHealthPoint;
    }

    @Override
    public double getMaxEnergy() {
      return maxTiredness;
    }

    @Override
    public double getCurrentEnergy() {
      return currentTiredness;
    }
  }
}