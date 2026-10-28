
public class GenericArraySum {
    public static <T extends Number> double sum(T[] array) {
        double total = 0.0;

        for (T num : array) {
            total += num.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {

        Integer[] intArray = {10, 20, 30, 40};
        Float[] floatArray = {1.5f, 2.5f, 3.5f};
        Double[] doubleArray = {10.5, 20.5, 30.5};

        System.out.println("Sum of Integer array: "+ sum(intArray));

        System.out.println("Sum of Float array: "+ sum(floatArray));

        System.out.println("Sum of Double array: "+ sum(doubleArray));
    }
}
