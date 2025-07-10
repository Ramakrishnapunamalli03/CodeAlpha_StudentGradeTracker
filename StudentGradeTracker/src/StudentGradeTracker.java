import java.util.*;

public class StudentGradeTracker {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Student Grade Tracker ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Show Average Grade");
            System.out.println("4. Show Highest Grade");
            System.out.println("5. Show Lowest Grade");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayAll();
                case 3 -> showAverage();
                case 4 -> showHighest();
                case 5 -> showLowest();
                case 6 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student grade: ");
        int grade = scanner.nextInt();
        scanner.nextLine();

        students.add(new Student(name, grade));
        System.out.println("Student added!");
    }

    private static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No student data found.");
            return;
        }

        System.out.println("\n--- Student Records ---");
        for (Student s : students) {
            System.out.println("Name: " + s.getName() + ", Grade: " + s.getGrade());
        }
    }

    private static void showAverage() {
        if (students.isEmpty()) {
            System.out.println("No data to calculate average.");
            return;
        }

        int sum = 0;
        for (Student s : students) {
            sum += s.getGrade();
        }

        double avg = (double) sum / students.size();
        System.out.printf("Average Grade: %.2f%n", avg);
    }

    private static void showHighest() {
        if (students.isEmpty()) {
            System.out.println("No data to calculate highest.");
            return;
        }

        Student top = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > top.getGrade()) {
                top = s;
            }
        }

        System.out.println("Highest Grade: " + top.getGrade() + " (" + top.getName() + ")");
    }

    private static void showLowest() {
        if (students.isEmpty()) {
            System.out.println("No data to calculate lowest.");
            return;
        }

        Student low = students.get(0);
        for (Student s : students) {
            if (s.getGrade() < low.getGrade()) {
                low = s;
            }
        }

        System.out.println("Lowest Grade: " + low.getGrade() + " (" + low.getName() + ")");
    }
}
