public class Main {
  public static void main(String[] args) {
    Sniper sniper = new Sniper("Sniper");
    Medic medic = new Medic("Medic");
    Sapper sapper = new Sapper("Sapper");

    sniper.attack(sapper);
    medic.restoreHealth(sapper);
    sapper.attack(sniper);
  }
}