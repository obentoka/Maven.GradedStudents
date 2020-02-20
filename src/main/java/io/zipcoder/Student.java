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
        this.examScores = new ArrayList<>(testScores.length);
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

    public ArrayList<Double> getExams() {
        return examScores;
    }

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getExamScores(){
        StringBuilder returnString = new StringBuilder();
        for(Double e : this.examScores){
            returnString.append("Exam " + this.examScores.indexOf(e) +
                    " -> " + e.intValue()+ "\n");
        }
        return returnString.toString();
    }
}
