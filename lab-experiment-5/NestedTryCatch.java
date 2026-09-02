public class NestedTryCatch {

    public static void main(String[] args) {

        try {
            System.out.println("Outer try block started.");

            try {
                System.out.println("Inner try block started.");

                // Generates ArithmeticException
                int result = 10 / 0;

                System.out.println("This statement will not execute.");

            } catch (NullPointerException e) {
                // This does NOT handle ArithmeticException
                System.out.println("Inner catch: NullPointerException handled.");
            }

            System.out.println("Back in outer try block.");

            // Generates ArrayIndexOutOfBoundsException
            int[] arr = {10, 20, 30};
            System.out.println(arr[5]);

        } catch (ArithmeticException e) {
            System.out.println("Outer catch: ArithmeticException handled.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: ArrayIndexOutOfBoundsException handled.");
        }

        System.out.println("Program continues after exception handling.");
    }
}
