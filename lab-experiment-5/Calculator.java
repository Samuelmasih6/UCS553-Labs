import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Input two numbers
            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            // Input operator
            System.out.print("Enter operator (+, -, *, /): ");
            String operator = scanner.nextLine();

            double result;

            // Perform calculation
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;

                case "-":
                    result = num1 - num2;
                    break;

                case "*":
                    result = num1 * num2;
                    break;

                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = num1 / num2;
                    break;

                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }

            System.out.println("Result = " + result);

        } catch (NumberFormatException e) {
            // Handles invalid numeric input
            System.out.println("Error: Please enter valid numbers.");

        } catch (ArithmeticException e) {
            // Handles division by zero
            System.out.println("Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            // Handles invalid operators
            System.out.println("Error: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}
