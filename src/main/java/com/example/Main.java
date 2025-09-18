package com.example;

import java.util.List;
import java.util.Scanner;


public class Main {
    private static final String DATA_FILE = "data/students.json";

    public static void main(String[] args) {
        try {
            List<Student> students = FileUtils.readStudents(DATA_FILE);
            StudentManager manager = new StudentManager(students);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Add 2. Edit 3. Delete 4. List 5. Exit");
                int choice = sc.nextInt(); sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                        System.out.print("RollNumber: "); String roll = sc.nextLine();
                        System.out.print("Grade: "); String grade = sc.nextLine();
                        manager.addStudent(new Student(name, age, roll, grade));
                    }
                    case 2 -> {
                        System.out.print("RollNumber to edit: "); String roll = sc.nextLine();
                        System.out.print("New Name: "); String name = sc.nextLine();
                        System.out.print("New Age: "); int age = sc.nextInt(); sc.nextLine();
                        System.out.print("New Grade: "); String grade = sc.nextLine();
                        if (!manager.editStudent(roll, new Student(name, age, roll, grade)))
                            System.out.println("Student not found!");
                    }
                    case 3 -> {
                        System.out.print("RollNumber to delete: "); String roll = sc.nextLine();
                        if (!manager.deleteStudent(roll))
                            System.out.println("Student not found!");
                    }
                    case 4 -> manager.getStudents().forEach(System.out::println);
                    case 5 -> {
                        FileUtils.writeStudents(DATA_FILE, manager.getStudents());
                        System.out.println("Data saved. Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
