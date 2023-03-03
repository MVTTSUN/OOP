public class Player {
  private static Long count = 0L;
  private Long id = 0L;
  private String name;
  private double damage;
  private double maxHealthPoint;
  private double healthPoint;

  public Player(String name) {
    this.name = name;
    this.id = ++count;
  }

  public String getName() {
    return this.name;
  }

  public double getMaxHealthPoint() {
    return this.maxHealthPoint;
  }

  public void setMaxHealthPoint(double maxHealthPoint) {
    this.maxHealthPoint = maxHealthPoint;
  }

  public double getHealthPoint() {
    return this.maxHealthPoint;
  }

  public void setHealthPoint(double healthPoint) {
    this.healthPoint = healthPoint;
  }

  public double getDamage() {
    return this.damage;
  }

  public void setDamage(double damage) {
    this.damage = damage;
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
