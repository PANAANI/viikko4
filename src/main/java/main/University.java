package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class University {
    final private String FILENAME;
    private ArrayList<Student> students = new ArrayList<>();
    public University() {
        FILENAME = "students.data";
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void listStudentsByStudentNumber() {
        System.out.println("Opiskelijat:");
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
    public void saveStudents() {
        try {
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentWriter.writeObject(students);
            studentWriter.close();
        } catch (IOException exception) {
            System.out.println("Tiedoston käsittelyssä virhe");
            exception.printStackTrace();
        }
    }
    public void loadStudents() {
        try {
            ObjectInputStream studentReader = new ObjectInputStream(new FileInputStream(FILENAME));
            students = (ArrayList<Student>) studentReader.readObject();
            studentReader.close();
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Tiedoston käsittelyssä virhe");
            exception.printStackTrace();
        } 
    }
}
