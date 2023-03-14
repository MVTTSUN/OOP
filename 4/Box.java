import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box<T extends Fruit> implements  Iterable<T> {
  private List<T> fruitList = new ArrayList<>();

  public void add(T fruit) {
    this.fruitList.add(fruit);
  }

  public int getWeight() {
    int result = 0;
    for (T fruit : this.fruitList) {
      result += fruit.getWeight();
    }

    return result;
  }

  public void moveTo(Box<? super T> target) {
    for (T fruit : this.fruitList) {
      target.add(fruit);
    }
    this.fruitList.clear();
  }

  @Override
  public Iterator<T> iterator() {
    return new FruitIterator<>(this.fruitList);
  }
}