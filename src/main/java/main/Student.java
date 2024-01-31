package main;

import java.io.Serializable;
import java.util.HashMap;

public class Student implements Serializable {
    final private String student_name;
    final private String student_number;
    final private static long serialVersionUID = 24314314L;
    private HashMap<String, Integer> grades = new HashMap<>();
    public Student(String _student_name, String _student_number) {
        student_name = _student_name;
        student_number = _student_number;
    }
    public void addGrade(String course, int grade) {
        grades.put(course, grade);
    }
    public void listGrades() {
        for (String i : grades.keySet()) {
            System.out.println(i + ": " + grades.get(i));
        }
    }
    public HashMap<String, Integer> getStudentGrades() {
        return grades;
    }
    public String getStudentName() {
        return student_name;
    }
    public String getStudentNumber() {
        return student_number;
    }
}
