package io.zipcoder;

import java.util.Comparator;

public class CompareStudents implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2){
        if (o1.getAverageExamScore().equals(o2.getAverageExamScore())){
            if(o1.getLastName().equalsIgnoreCase(o2.getLastName())){
                return o1.getFirstName().compareTo(o2.getFirstName());
            }else {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        }else {
            if(o1.getAverageExamScore() > o2.getAverageExamScore()){
                return -1;
            }
            if(o1.getAverageExamScore() < o2.getAverageExamScore()){
                return 1;
            }
        }
        return 0;
    }
}
