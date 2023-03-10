public class Notebook {
  private static int count = 0;
  private int price;
  private int capacityRAM;
  private int id;

  public Notebook(int price, int capacityRAM) {
    this.id = ++count;
    this.price = price;
    this.capacityRAM = capacityRAM;
  }

  public int getCapacityRAM() {
    return this.capacityRAM;
  }
  public int getPrice() {
    return this.price;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return String.format("\nid: %d, цена: %d, оперативная память %d", this.id, this.price, this.capacityRAM);
  }
}
