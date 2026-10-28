
import java.util.Optional;

public class OptionalEmailDemo {
    public static void main(String[] args) {
        Optional<String> email = Optional.of("student@gmail.com");

        Optional<String> emptyEmail = Optional.empty();

        System.out.print("Student Email: ");
        email.ifPresent(System.out::println);

        String defaultEmail = emptyEmail.orElse("default@gmail.com");

        System.out.println("Default Email: " + defaultEmail);

        try {
            String missingEmail = emptyEmail.orElseThrow(
                    () -> new RuntimeException("Email is missing!")
            );

            System.out.println("Missing Email: " + missingEmail);

        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
