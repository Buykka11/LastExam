package main;

import model.Student;
import service.StudentManager;
import utils.FileHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);


        var students = FileHandler.loadFromFile();
        if (students != null) {
            students.forEach(manager::addStudent);
        }

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Save and Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    String id = scanner.next();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Department: ");
                    String department = scanner.next();
                    System.out.print("Enter Grade: ");
                    double grade = scanner.nextDouble();
                    manager.addStudent(new Student(id, name, department, grade));
                }
                case 2 -> {
                    System.out.print("Enter Student ID: ");
                    String id = scanner.next();
                    var student = manager.searchStudentById(id);
                    System.out.println(student != null ? student : "Student not found.");
                }
                case 3 -> {
                    System.out.print("Enter Student ID to delete: ");
                    String id = scanner.next();
                    manager.deleteStudentById(id);
                }
                case 4 -> manager.getAllStudents().forEach(System.out::println);
                case 5 -> {
                    FileHandler.saveToFile(manager.getAllStudents());
                    System.out.println("Data saved. Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
