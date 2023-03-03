public class Medic extends Player {
  double healthRestorePoint = 50;

  public Medic(String name) {
    super(name);
    this.damage = 10;
    this.maxHealthPoint = 150;
    this.healthPoint = this.maxHealthPoint;
  }

  public void restoreHealth(Player player) {
    if (this.maxHealthPoint > player.healthPoint + this.healthRestorePoint) {
      player.healthPoint += this.healthRestorePoint;
    } else {
      player.healthPoint = player.maxHealthPoint;
    }
    System.out.printf("%s вылечил %s на %f. У %s осталось %f очков жизни\n", this.name, player.name, this.healthRestorePoint, player.name, player.healthPoint);
  }
}