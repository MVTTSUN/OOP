public class Player {
  static Long count = 0L;
  protected Long id = 0L;
  protected String name;
  protected double damage;
  protected double maxHealthPoint;
  protected double healthPoint;

  public Player(String name) {
    this.name = name;
    this.id = ++count;
  }

  public void attack(Player player) {
    if (player.healthPoint - this.damage <= 0) {
      player.healthPoint = 0;
    } else {
      player.healthPoint -= this.damage;
    }
    System.out.printf("%s атакует %s на %f. У %s осталось %f очков жизни\n", this.name, player.name, this.damage, player.name, player.healthPoint);
  }

  @Override
  public String toString() {
    return String.format("id: %d, name: %s, health: %f", this.id, this.name, this.healthPoint);
  }
}
