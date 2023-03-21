import java.util.List;

public class Help implements CommandHandler {
  private List<CommandHandler> handlers;

  @Override
  public String commandName() {
    return "help";
  }

  @Override
  public void handleCommand(RobotMap map, String[] args) {
    viewCommand(this.handlers);
  }

  public void viewCommand(List<CommandHandler> handlers) {
    this.handlers = handlers;
    
    System.out.println("Список доступных команд:");
    handlers.stream().forEach(handle -> System.out.println(handle.commandName()));
  }
}