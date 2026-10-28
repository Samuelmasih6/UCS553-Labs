import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

public class EventManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String eventName = sc.nextLine();

        System.out.print("Enter event date (YYYY-MM-DD): ");
        LocalDate eventDate = LocalDate.parse(sc.nextLine());

        System.out.print("Enter start time (HH:MM): ");
        LocalTime startTime = LocalTime.parse(sc.nextLine());

        System.out.print("Enter venue (leave blank if absent): ");
        String venueInput = sc.nextLine();

        Optional<String> venue = venueInput.isBlank()
                ? Optional.empty()
                : Optional.of(venueInput);

        LocalTime endTime = startTime.plusHours(2);

        System.out.println("\n--- Event Details ---");
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);

        System.out.println("Venue: "
                + venue.orElse("Venue not specified"));

        LocalDate today = LocalDate.now();

        if (eventDate.isAfter(today)) {
            System.out.println("Status: Future event");

        } else if (eventDate.isEqual(today)) {
            System.out.println("Status: Event is today");

        } else {
            System.out.println("Status: Event is in the past");
        }

        long daysRemaining =
                ChronoUnit.DAYS.between(today, eventDate);

        System.out.println("Days remaining: " + daysRemaining);

        sc.close();
    }
}
