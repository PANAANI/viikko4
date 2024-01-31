package main;

import java.util.Arrays;

public class Calculator {
    public Calculator() {

    }
    public double getAverageGrade(Student student) {
        int sum = 0;
        int iterations = 0;
        for (Integer i : student.getStudentGrades().values()) {
            sum += i;
            iterations += 1;
        }
        double average = 0;
        average = (double)(sum) / (double)(iterations);
        return average;
    }
    public double getMedianGrade(Student student) {
        int[] grade_array = new int[student.getStudentGrades().size()];
        int index = 0;
        for (Integer i : student.getStudentGrades().values()) {
            grade_array[index] = i;
            index++;
        }
        Arrays.sort(grade_array);
        int median_index = (int)(Math.floor(grade_array.length / 2));
        double median = grade_array[median_index];
        return median;
    }
}
