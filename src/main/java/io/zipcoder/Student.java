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
            returnString.append("Exam " + (this.examScores.indexOf(e)+1) +
                    " -> " + e.intValue()+ "\n");
        }
        return returnString.toString();
    }

    public void addExamScore(double examScore){
        this.examScores.add(examScore);
    }

    public void setExamScore(Integer examIndex, Double changeScore){
        this.examScores.set(examIndex-1, changeScore);
    }

    public Double getAverageExamScore(){
        Double sum = 0.0;
        for(Double i : this.examScores){
            sum += i.intValue();
        }
        return sum / this.examScores.size();
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        int avgScore = getAverageExamScore().intValue();
        returnString.append("Average Score: " + avgScore + "\n");
        returnString.append("Exam Scores: \n");
        returnString.append(getExamScores());

        return returnString.toString();
    }
}
