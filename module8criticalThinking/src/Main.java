
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        LinkedList<Student> students = new LinkedList<>();

        Scanner kb = new Scanner(System.in);

        String myChoice;

        do {
            System.out.println("Enter student name: ");
            String name = kb.nextLine();

            System.out.println("Enter student address: ");
            String address = kb.nextLine();

            double GPA = 0.0;
            while (true) {
                System.out.println("Enter student GPA: ");
                String gpaInput = kb.nextLine();

                try {
                    GPA = Double.parseDouble(gpaInput);
                    if (GPA >= 0.0 && GPA <= 4.0) {
                        break;
                    } else {
                        System.out.println("GPA must be between 0.0 and 4.0. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid GPA. Please enter a numeric value between 0.0 and 4.0.");
                }
            }

            students.add(new Student(name, address, GPA));

            System.out.println("Do you want to add another student? (yes/no): ");
            myChoice = kb.nextLine();
        } while (myChoice.equalsIgnoreCase("yes"));

        Collections.sort(students);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data has been written to students.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        kb.close();

    }
}