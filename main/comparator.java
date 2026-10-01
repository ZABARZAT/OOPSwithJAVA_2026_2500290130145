package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparator implements Comparator<Student> {

	@Override
	public int compare(Student first, Student second) {
		return Integer.compare(first.rollNo, second.rollNo);
	}

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Asha", 103));
		students.add(new Student("Ravi", 101));
		students.add(new Student("Mina", 102));

		Collections.sort(students, new comparator());

		for (Student student : students) {
			System.out.println(student);
		}
	}
}

class Student {
	String name;
	int rollNo;

	Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "Roll No: " + rollNo + ", Name: " + name;
	}
}
