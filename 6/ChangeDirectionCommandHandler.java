public class ChangeDirectionCommandHandler implements CommandHandler {
  @Override
  public String commandName() {
    return "change-direction";
  }

  @Override
  public void handleCommand(RobotMap map, String[] args) {
    RobotMap.Direction newDirection = RobotMap.Direction.valueOf(args[1]);
    RobotMap.Robot robotById = map.findRobotById(Integer.parseInt(args[0]));

    if (robotById != null) {
      robotById.changeDirection(newDirection);
    } else {
      System.out.println("Робот с идентификатором " + args[0] + " не найден");
    }
  }
}