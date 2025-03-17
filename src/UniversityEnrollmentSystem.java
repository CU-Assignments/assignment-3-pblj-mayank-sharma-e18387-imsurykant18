import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollmentSystem {
    private static final int MAX_CAPACITY = 30;
    private static int enrolledStudents = 30;
    private static boolean prerequisiteCompleted = false;

    public static void enrollInCourse(String course, String prerequisite) throws CourseFullException, PrerequisiteNotMetException {
        if (!prerequisiteCompleted) throw new PrerequisiteNotMetException("Complete " + prerequisite + " before enrolling in " + course + ".");
        if (enrolledStudents >= MAX_CAPACITY) throw new CourseFullException("The course " + course + " is full.");
        
        enrolledStudents++;
        System.out.println("Enrollment successful in " + course + "!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enroll in Course: ");
        String course = sc.nextLine();
        System.out.print("Prerequisite: ");
        String prerequisite = sc.nextLine();
        try {
            enrollInCourse(course, prerequisite);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}