public class Sniper extends Player {
  public Sniper(String name) {
    super(name);
    this.damage = 100;
    this.maxHealthPoint = 100;
    this.healthPoint = this.maxHealthPoint;
  }
}