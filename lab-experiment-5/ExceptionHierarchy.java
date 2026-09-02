public class ExceptionHierarchy {

    public static void main(String[] args) {

        System.out.println("Java Exception Hierarchy:");
        System.out.println("Throwable");
        System.out.println(" └── Exception");
        System.out.println("      └── RuntimeException");
        System.out.println("           ├── ArithmeticException");
        System.out.println("           ├── NullPointerException");
        System.out.println("           ├── ArrayIndexOutOfBoundsException");
        System.out.println("           └── NumberFormatException");

        System.out.println("\n--- Demonstrating Exceptions ---");

        // 1. ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("1. ArithmeticException: " + e.getMessage());
        }

        // 2. NullPointerException
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("2. NullPointerException: " + e.getMessage());
        }

        // 3. ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {10, 20, 30};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("3. ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // 4. NumberFormatException
        try {
            String value = "abc";
            int number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("4. NumberFormatException: " + e.getMessage());
        }
    }
}
