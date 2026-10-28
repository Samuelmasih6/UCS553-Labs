
import java.util.Optional;
import java.util.Objects;

class Result<T extends Number> {
    private final String studentName;
    private final T[] marks;
    private final double passingThreshold;

    public Result(String studentName, T[] marks,
                  double passingThreshold) {

        this.studentName = Objects.requireNonNull(
                studentName, "Student name cannot be null");

        this.marks = Objects.requireNonNull(
                marks, "Marks cannot be null");

        this.passingThreshold = passingThreshold;
    }

    public double calculateAverage() {
        double total = 0.0;

        for (T mark : marks) {
            total += Objects.requireNonNull(
                    mark, "Mark cannot be null").doubleValue();
        }

        return total / marks.length;
    }

    public double calculatePercentage() {
        return calculateAverage();
    }

    public boolean hasPassed() {
        return calculatePercentage() >= passingThreshold;
    }

    public void displayResult() {
        Optional<T[]> optionalMarks = Optional.ofNullable(marks);

        optionalMarks.ifPresent(m -> {
            System.out.println("Student Name: " + studentName);
            System.out.printf("Average Marks: %.2f%n",
                              calculateAverage());
            System.out.printf("Percentage: %.2f%%%n",
                              calculatePercentage());
            System.out.println("Result: "
                    + (hasPassed() ? "PASS" : "FAIL"));
        });
    }
}

public class Main {
    public static void main(String[] args) {

        Double[] marks = {85.0, 90.0, 78.0, 88.0, 92.0};

        Result<Double> student =
                new Result<>("Rahul", marks, 40.0);

        student.displayResult();
    }
}
