public class Sapper extends Player {
  public Sapper(String name) {
    super(name);
    this.damage = 50;
    this.maxHealthPoint = 120;
    this.healthPoint = this.maxHealthPoint;
  }
}
