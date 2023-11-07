import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private double totalFee;
    private double paidFee;
    private double remainingFee;

    public Student(String studentId, String name, double totalFee) {
        this.studentId = studentId;
        this.name = name;
        this.totalFee = totalFee;
        this.paidFee = 0;
        this.remainingFee = totalFee;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public double getPaidFee() {
        return paidFee;
    }

    public double getRemainingFee() {
        return remainingFee;
    }

    public void makePayment(double amount) {
        paidFee += amount;
        remainingFee -= amount;
    }
}

class FeesManagementSystem {
    private List<Student> students;

    public FeesManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudentDetails(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Name: " + student.getName());
                System.out.println("Total Fee: " + student.getTotalFee());
                System.out.println("Paid Fee: " + student.getPaidFee());
                System.out.println("Remaining Fee: " + student.getRemainingFee());
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void makePayment(String studentId, double amount) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.makePayment(amount);
                System.out.println("Payment of " + amount + " made successfully for student " + student.getName());
                return;
            }
        }
        System.out.println("Student not found!");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FeesManagementSystem feesManagementSystem = new FeesManagementSystem();

        // Add some sample students
        feesManagementSystem.addStudent(new Student("S001", "John Doe", 5000));
        feesManagementSystem.addStudent(new Student("S002", "Jane Smith", 6000));

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Make Payment");
            System.out.println("3. Display Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter total fee: ");
                    double totalFee = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    feesManagementSystem.addStudent(new Student(studentId, name, totalFee));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    System.out.print("Enter payment amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    feesManagementSystem.makePayment(studentId, amount);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    feesManagementSystem.displayStudentDetails(studentId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        }
    }
}
