import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {
  // Создать класс Notebook с полями:
  // 1. Стоимость (int)
  // 2. Оперативная память (int)
  // Нагенерить объектов этого класса, создать список и отсортировать его в трех вариантах:
  // 1. По возрастанию цены
  // 2. По убыванию цены
  // 3. По оперативке по убыванию. Если оперативки равны - по убыванию цены.
  // 4.+ придумать свои параметры и отсортировать по ним
  public static void main(String[] args) {
    List<Notebook> notebooks = new ArrayList<>(IntStream
      .range(0, 10)
      .mapToObj(el -> {
        int[] arrayCapacity = new int[] {4, 6, 8, 12, 16, 20, 24, 32, 64};
        int[] array = new int[] {ThreadLocalRandom.current().nextInt(100, 300), arrayCapacity[ThreadLocalRandom.current().nextInt(arrayCapacity.length)]};
        return array;
      })
      .map((nums) -> new Notebook(nums[0], nums[1])).toList());

    Comparator<Notebook> comparatorId = (a, b) -> a.getId() - b.getId();
    Comparator<Notebook> comparatorPriceUp = (a, b) -> a.getPrice() - b.getPrice();
    Comparator<Notebook> comparatorPriceDown = (a, b) -> b.getPrice() - a.getPrice();
    Comparator<Notebook> comparatorCapacityRAM = (a, b) -> b.getCapacityRAM() - a.getCapacityRAM();

    // 1. По возрастанию цены
    Collections.sort(notebooks, comparatorPriceUp);

    // 2. По убыванию цены
    Collections.sort(notebooks, comparatorPriceDown);

    // 3. По оперативке по убыванию. Если оперативки равны - по убыванию цены.
    Collections.sort(notebooks, comparatorPriceDown);
    Collections.sort(notebooks, comparatorCapacityRAM);

    // Возвращение в исходное состояние списка
    Collections.sort(notebooks, comparatorId);

    System.out.println(notebooks);
  }
}
