import java.util.*;

class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println(rollNo + "\t" + name + "\t" + marks);
    }
}

public class StudentRankingSystem {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(103, "Rahul", 85));
        students.add(new Student(101, "Aman", 92));
        students.add(new Student(105, "Riya", 85));
        students.add(new Student(102, "Karan", 92));
        students.add(new Student(104, "Neha", 78));

        // Comparator for sorting students
        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                // Higher marks first
                if (s1.marks != s2.marks) {
                    return Integer.compare(s2.marks, s1.marks);
                }

                // If marks are same, smaller roll number first
                return Integer.compare(s1.rollNo, s2.rollNo);
            }
        });

        System.out.println("Roll No\tName\tMarks");
        System.out.println("------------------------");

        for (Student s : students) {
            s.display();
        }
    }
}