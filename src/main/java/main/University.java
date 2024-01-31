package main;

import java.util.ArrayList;

public class University {
    private ArrayList<Student> students = new ArrayList<>();
    public University() {

    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void listStudentsByStudentNumber() {
        for (Student i : students) {
            System.out.println(i.getStudentNumber() + ": " + i.getStudentName());
        }
    }
    public void listStudentsByListIndex() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ": " + students.get(i).getStudentName());
        }
    }
    public Student getStudentByIndex(int index) {
        return students.get(index);
    }
}
