package io.zipcoder;

import java.util.*;

public class Classroom {
    private Map<Integer,Student> students;
    private Integer id = 0;

    public Classroom(){
        this.students = new HashMap<>(30);
    }

    public Classroom(Integer size){
        this.students = new HashMap<>(size);
    }

    public Classroom(Student[] input){
        students = new HashMap<>(input.length);
        for (;this.id < input.length; this.id++) {
            students.put(this.id, input[this.id]);
        }
    }

    public Student[] getStudents(){
        Student[] returnStudent = new Student[students.size()];
        for (int i = 0; i < students.size(); i++) {
            returnStudent[i] = students.get(i);
        }
        return returnStudent;
    }

    public Double getAverageExamScore(){
        Double sum = 0.0;
        for (int i = 0; i < this.students.size(); i++) {
            sum += students.get(i).getAverageExamScore();
        }
        return sum / this.students.size();
    }

    public void addStudent(Student student){
        this.students.put(id, student);
        id++;
    }
}
