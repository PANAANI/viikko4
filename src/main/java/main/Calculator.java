package main;

import java.util.Arrays;

public class Calculator {
    public Calculator() {

    }
    public double getAverageGrade(Student student) {
        if (student.getStudentGrades().size() == 0) {
            return 0;
        }
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
        int input_size = student.getStudentGrades().size();
        if (input_size == 0) {
            return 0;
        }
        int[] grade_array = new int[student.getStudentGrades().size()];
        int index = 0;
        for (Integer i : student.getStudentGrades().values()) {
            grade_array[index] = i;
            index++;
        }
        Arrays.sort(grade_array);
        int median_index = 0;
        double median = 0;
        int input_remainder = input_size % 2;
        if (input_remainder == 1) {
            median_index = (int)(Math.floor((double)(grade_array.length) / 2d));
            median = grade_array[median_index];
        } else if (input_remainder == 0) {
            median = (grade_array[grade_array.length / 2] + grade_array[(grade_array.length / 2) + 1]) / 2;
        }
        return median;
    }
}
