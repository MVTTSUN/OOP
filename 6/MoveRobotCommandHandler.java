public class MoveRobotCommandHandler implements CommandHandler {
  @Override
  public String commandName() {
    return "move-robot";
  }

  @Override
  public void handleCommand(RobotMap map, String[] args) {
    try {
      map.findRobotById(Integer.parseInt(args[0])).move();
    } catch (PositionException e) {
      System.out.println("При создании робота возникло исключение: " + e.getMessage() + "." + " Попробуйте еще раз");
    }
  }
}