import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=== Student Record Management System ===");

        while (running) {
            System.out.println("\n1) Add Student");
            System.out.println("2) View Students");
            System.out.println("3) Update Student");
            System.out.println("4) Delete Student");
            System.out.println("5) Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    running = false;
                    System.out.println("Exiting program...");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    // Add
    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        students.add(new Student(id, name, marks));
        System.out.println("✅ Student added successfully!");
    }

    // View
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Update
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new Name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new Marks: ");
                s.setMarks(sc.nextDouble());
                System.out.println("✅ Student updated successfully!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    // Delete
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        students.removeIf(s -> s.getId() == id);
        System.out.println("✅ Student deleted (if ID existed).");
    }
}
