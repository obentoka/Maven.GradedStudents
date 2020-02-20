package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String fName, String lName, Double[] testScores){
        this.firstName = fName;
        this.lastName = lName;
        for(Double i : testScores){
            this.examScores.add(i);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }
}
