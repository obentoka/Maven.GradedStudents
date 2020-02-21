package io.zipcoder;

public class Classroom {
    Student[] students;

    public Classroom(){
        this.students = new Student[30];
    }

    public Classroom(Integer size){
        this.students = new Student[size];
    }

    public Classroom(Student[] input){
        this.students = input;
    }
}
