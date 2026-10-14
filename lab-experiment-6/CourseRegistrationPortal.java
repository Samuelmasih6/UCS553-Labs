import java.util.*;

class Course {
    private String courseCode;
    private String courseName;
    private int capacity;

    private HashSet<String> enrolledStudents;
    private ArrayList<String> prerequisites;
    private LinkedList<String> waitlist;

    public Course(String courseCode, String courseName, int capacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.capacity = capacity;

        enrolledStudents = new HashSet<>();
        prerequisites = new ArrayList<>();
        waitlist = new LinkedList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public HashSet<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public ArrayList<String> getPrerequisites() {
        return prerequisites;
    }

    public LinkedList<String> getWaitlist() {
        return waitlist;
    }

    public void addPrerequisite(String prerequisiteCode) {
        if (!prerequisites.contains(prerequisiteCode)) {
            prerequisites.add(prerequisiteCode);
        }
    }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    public boolean enrollStudent(String studentId) {
        if (isFull()) {
            return false;
        }

        return enrolledStudents.add(studentId);
    }

    public boolean addToWaitlist(String studentId) {

        if (enrolledStudents.contains(studentId)) {
            return false;
        }

        if (waitlist.contains(studentId)) {
            return false;
        }

        waitlist.addLast(studentId);
        return true;
    }

    public boolean removeStudent(String studentId) {
        return enrolledStudents.remove(studentId);
    }

    public String promoteFromWaitlist() {

        if (isFull() || waitlist.isEmpty()) {
            return null;
        }

        String studentId = waitlist.removeFirst();
        enrolledStudents.add(studentId);

        return studentId;
    }

    public void displayCourse() {
        System.out.println("Course Code : " + courseCode);
        System.out.println("Course Name : " + courseName);
        System.out.println("Capacity    : " + capacity);

        System.out.println("Prerequisites:");
        if (prerequisites.isEmpty()) {
            System.out.println("None");
        } else {
            for (String prerequisite : prerequisites) {
                System.out.println("  " + prerequisite);
            }
        }

        System.out.println("Enrolled Students: " + enrolledStudents);
        System.out.println("Waitlist: " + waitlist);
    }
}


public class CourseRegistrationPortal {

    private HashMap<String, Course> courses;

    public CourseRegistrationPortal() {
        courses = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.put(course.getCourseCode(), course);
        System.out.println("Course " + course.getCourseCode() + " added successfully.");
    }

    public Course findCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public void registerStudent(String studentId, String courseCode) {

        Course course = courses.get(courseCode);

        if (course == null) {
            System.out.println("Course not found: " + courseCode);
            return;
        }

        if (course.getEnrolledStudents().contains(studentId)) {
            System.out.println(
                    studentId + " is already enrolled in " + courseCode
            );
            return;
        }

        if (course.getWaitlist().contains(studentId)) {
            System.out.println(
                    studentId + " is already on the waitlist."
            );
            return;
        }

        if (!course.isFull()) {

            course.enrollStudent(studentId);

            System.out.println(
                    studentId + " successfully enrolled in " + courseCode
            );

        } else {
            course.addToWaitlist(studentId);

            System.out.println(
                    "Course is full. " + studentId +
                    " added to waitlist for " + courseCode
            );
        }
    }

    public void dropStudent(String studentId, String courseCode) {

        Course course = courses.get(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        boolean removed = course.removeStudent(studentId);

        if (!removed) {
            System.out.println(
                    studentId + " is not enrolled in " + courseCode
            );
            return;
        }

        System.out.println(
                studentId + " dropped from " + courseCode
        );

        String promotedStudent = course.promoteFromWaitlist();

        if (promotedStudent != null) {

            System.out.println(
                    promotedStudent +
                    " automatically promoted from waitlist."
            );
        }
    }

    public void displayAllCourses() {

        for (Course course : courses.values()) {
            course.displayCourse();
        }
    }

    public static void main(String[] args) {

        CourseRegistrationPortal portal =
                new CourseRegistrationPortal();

        Course dsa = new Course(
                "CS201",
                "Data Structures and Algorithms",
                2
        );

        Course dbms = new Course(
                "CS301",
                "Database Management Systems",
                2
        );

        Course os = new Course(
                "CS302",
                "Operating Systems",
                2
        );

        dbms.addPrerequisite("CS101");
        dbms.addPrerequisite("CS201");

        os.addPrerequisite("CS201");

        portal.addCourse(dsa);
        portal.addCourse(dbms);
        portal.addCourse(os);

        portal.registerStudent("S101", "CS201");
        portal.registerStudent("S102", "CS201");

        portal.registerStudent("S103", "CS201");

        portal.registerStudent("S101", "CS201");

        portal.dropStudent("S101", "CS201");

        portal.registerStudent("S101", "CS301");
        portal.registerStudent("S102", "CS301");
        portal.registerStudent("S103", "CS301");

        portal.displayAllCourses();
    }
}
