public class Sniper extends Player {
  public Sniper(String name) {
    super(name);
    this.setDamage(100);
    this.setMaxHealthPoint(100);
    this.setHealthPoint(this.getMaxHealthPoint());
  }
}