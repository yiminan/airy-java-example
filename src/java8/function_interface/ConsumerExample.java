package java8.function_interface;

import java.util.Arrays;
import java.util.List;

/**
 * <p> Functional Interface "Consumer"
 * <p> : To use "Behavior parameters", Use "Functional Interface"
 * <p> - You can implement dynamic parameters for behavior by using "Functional Interface"
 * <p> - You can check validation by declaring "@FunctionalInterface"
 * <p> - To be used for processing inner logic by java8.lambda expression, Use "Consumer"
 *
 * @author Yimin An
 * @see java.util.function.Consumer
 * @see java.util.function.IntConsumer
 * @see java.util.function.DoubleConsumer
 */
public class ConsumerExample {

  @FunctionalInterface
  public interface Consumer<T> {

    void accept(T t);
  }

  public static <T> void forEach(List<T> list, Consumer<T> c) {
    for (T i : list) {
      c.accept(i);
    }
  }

  public static void main(String[] args) {
    Consumer<Integer> systemPrintIntegerConsumer = (Integer i) -> System.out.println(i);
//    Consumer<Integer> systemPrintIntegerConsumer = System.out::println;
    ConsumerExample.forEach(
        Arrays.asList(1, 2, 3, 4, 5, 6, 7),
        systemPrintIntegerConsumer
    );
  }
}
