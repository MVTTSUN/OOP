public class Sapper extends Player {
  public Sapper(String name) {
    super(name);
    this.setDamage(50);
    this.setMaxHealthPoint(120);
    this.healthPoint = this.getMaxHealthPoint();
  }
}
