package java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Utility method "allMatch", "noneMatch", "anyMatch", "findAny", "findFirst"
 * <p> : method using for efficient "Short circuit"
 * <p> * What is "Short circuit"? "Even if it doesn't tours all elements, turn out whether true or not."
 * <p> - If "allMatch" finds element which is not matched, operation is terminated and return boolean result(false).
 * <p> - If "noneMatch" finds element which is matched, operation is terminated and return boolean result(false).
 * <p> - If "anyMatch" finds element which is matched, operation is terminated and return boolean result(true).
 * <p> - If "findAny" with "filter" finds element which is matched, operation is terminated and return element.
 * <p> - If "findFirst" with "filter" finds element which is matched, operation is terminated and return element.
 *
 * <p> Difference between "findAny" and "findFirst" with ".parallelStream()" exists.
 * <p> "findFirst" operates (1) parallel find, (2) merge, (3) and return first element which is found in list.
 * <p> "findAny" operates (1) parallel find (2) and return any element which is found.
 *
 * @author Yimin An
 */
public class StreamMatchExample {

  public static class Food {

    private final Integer number;
    private final String name;
    private final Integer calories;

    public Food(Integer number, String name, Integer calories) {
      this.number = number;
      this.name = name;
      this.calories = calories;
    }

    public Integer getNumber() {
      return number;
    }

    public String getName() {
      return name;
    }

    public Integer getCalories() {
      return calories;
    }

    @Override
    public String toString() {
      return "Food{" +
          "number=" + number +
          ", name='" + name + '\'' +
          ", calories=" + calories +
          '}';
    }
  }

  public static void main(String[] args) {
    List<Food> foods = new ArrayList<>();
    foods.add(new Food(2, "Beef", 800));
    foods.add(new Food(3, "Pork", 500));
    foods.add(new Food(1, "Potato", 300));
    foods.add(new Food(4, "Butter", 1100));

    System.out.println(foods.stream().allMatch((Food f) -> f.getCalories() < 500) ? "Heathy" : "Unhealty");
    System.out.println(foods.stream().noneMatch((Food f) -> f.getCalories() > 500) ? "Unhealthy" : "Healthy");
    System.out.println(foods.stream().anyMatch((Food f) -> f.getCalories() < 500) ? "NotBad" : "Unhealthy");
//    Unhealty
//    Healthy
//    NotBad
    foods.stream().filter((Food f) -> f.getCalories() < 800).findAny()
        .ifPresent((Food f) -> System.out.println(f.getName()));
    foods.stream().filter((Food f) -> f.getCalories() < 800).findFirst()
        .ifPresent((Food f) -> System.out.println(f.getName()));
//    Pork
//    Pork
  }
}
