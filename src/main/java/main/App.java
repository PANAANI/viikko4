package main;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        int student_index = 0;
        University university = new University();
        Calculator calculator = new Calculator();
        while (!"0".equals(choice)) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Anna opiskelijan nimi?");
                    String new_student_name = sc.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String new_student_number = sc.nextLine();
                    Student new_student = new Student(new_student_name, new_student_number);
                    university.addStudent(new_student);
                    break;
                case "2":
                    university.listStudentsByStudentNumber();
                    break;
                case "3":
                    university.listStudentsByListIndex();
                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    student_index = Integer.parseInt(sc.nextLine());
                    System.out.println("Mille kurssille suorite lisätään?");
                    String new_course = sc.nextLine();
                    System.out.println("Mikä arvosana kurssille lisätään?");
                    int new_grade = Integer.parseInt(sc.nextLine());
                    university.getStudentByIndex(student_index).addGrade(new_course, new_grade);
                    break;
                case "4":
                    university.listStudentsByListIndex();
                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    student_index = Integer.parseInt(sc.nextLine());
                    university.getStudentByIndex(student_index).listGrades();
                    break;
                case "5":
                    university.listStudentsByListIndex();
                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    student_index = Integer.parseInt(sc.nextLine());
                    double average = calculator.getAverageGrade(university.getStudentByIndex(student_index));
                    System.out.println("Keskiarvo on " + average);
                    break;
                case "6":
                    university.listStudentsByListIndex();
                    System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                    student_index = Integer.parseInt(sc.nextLine());
                    double median = calculator.getMedianGrade(university.getStudentByIndex(student_index));
                    System.out.println("Mediaani on " + median);
                    break;
                case "7":
                    university.saveStudents();
                    break;
                case "8":
                    university.loadStudents();
                    break;
                case "0":
                    System.out.println("Kiitos ohjelman käytöstä.");
                    sc.close();
                    break;
                default:
                    System.out.println("Syöte oli väärä");
                    break;
            }
        }
    }
}
