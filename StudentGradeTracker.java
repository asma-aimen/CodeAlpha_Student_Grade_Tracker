import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private HashMap<String, Integer> marks;
    private double average;
    private String grade;

    public Student(String name) {
        this.name = name;
        this.marks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addMark(String subject, int mark) {
        marks.put(subject, mark);
    }

    public HashMap<String, Integer> getMarks() {
        return marks;
    }

    public double getAverage() {
        return average;
    }

    public String getGrade() {
        return grade;
    }

    public void calculateAverageAndGrade() {
        int totalMarks = 0;
        for (int mark : marks.values()) {
            totalMarks += mark;
        }
        this.average = totalMarks / (double) marks.size();

        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
    }
}

class GradeCalculator {
    private ArrayList<Student> students;

    public GradeCalculator() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void calculateGrades() {
        for (Student student : students) {
            student.calculateAverageAndGrade();
        }
    }

    public void displayResults() {
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            System.out.println("Marks: " + student.getMarks());
            System.out.println("Average: " + student.getAverage());
            System.out.println("Grade: " + student.getGrade());
            System.out.println("------------------------");
        }
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeCalculator gradeCalculator = new GradeCalculator();

        System.out.print("Enter the number of students: ");
        int numOfStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numOfStudents; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.print("Enter the number of subjects: ");
            int numOfSubjects = scanner.nextInt();
            scanner.nextLine(); // consume newline

            for (int j = 0; j < numOfSubjects; j++) {
                System.out.print("Enter name of subject " + (j + 1) + ": ");
                String subject = scanner.nextLine();
                System.out.print("Enter marks for " + subject + ": ");
                int marks = scanner.nextInt();
                scanner.nextLine(); // consume newline

                student.addMark(subject, marks);
            }

            gradeCalculator.addStudent(student);
        }

        gradeCalculator.calculateGrades();
        gradeCalculator.displayResults();

        scanner.close();
    }
}
