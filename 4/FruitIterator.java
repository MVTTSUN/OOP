import java.util.Iterator;
import java.util.List;

public class FruitIterator<T> implements Iterator<T> {
  private int cursor = 0;
  private List<T> fruitList;

  public FruitIterator(List<T> fruitList) {
    this.fruitList = fruitList;
  }
    
  @Override
  public boolean hasNext() {
    return cursor < this.fruitList.size();
  }

  @Override
  public T next() {
    return this.fruitList.get(cursor++);
  }
}
