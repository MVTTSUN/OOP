public class Medic extends Player {
  double healthRestorePoint = 50;

  public Medic(String name) {
    super(name);
    this.setDamage(10);
    this.setMaxHealthPoint(150);
    this.healthPoint = this.getMaxHealthPoint();
  }

  public void restoreHealth(Player player) {
    if (this.getMaxHealthPoint() > player.healthPoint + this.healthRestorePoint) {
      player.healthPoint += this.healthRestorePoint;
    } else {
      player.healthPoint = player.getMaxHealthPoint();
    }
    System.out.printf("%s вылечил %s на %f. У %s осталось %f очков жизни\n", this.getName(), player.getName(), this.healthRestorePoint, player.getName(), player.healthPoint);
  }
}