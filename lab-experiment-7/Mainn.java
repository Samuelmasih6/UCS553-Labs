
import java.util.Optional;
import java.util.Objects;

class GenericUtility {

    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(
            Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class Mainn {
    public static void main(String[] args) {

        System.out.println("Strings equal: " +
                GenericUtility.isEqual("Java", "Java"));

        System.out.println("Integers equal: " +
                GenericUtility.isEqual(10, 20));

        Optional<String> name = Optional.of("Rahul");
        Optional<Integer> empty = Optional.empty();

        System.out.println("Name: " +
                GenericUtility.getDefault(name, "Guest"));

        System.out.println("Default number: " +
                GenericUtility.getDefault(empty, 100));

        System.out.println("Maximum integer: " +
                GenericUtility.max(25, 40));

        System.out.println("Maximum string: " +
                GenericUtility.max("Apple", "Banana"));

        String str = null;
        Integer number = 50;

        System.out.println("Is str null? " +
                GenericUtility.isNull(str));

        System.out.println("Is number null? " +
                GenericUtility.isNull(number));
    }
}
