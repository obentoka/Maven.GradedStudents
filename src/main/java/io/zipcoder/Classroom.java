package io.zipcoder;

import java.util.*;
import java.util.logging.Logger;

public class Classroom {

    private static final Logger LOGGER =
            Logger.getLogger((Classroom.class.getName()));

    private List<Student> students;
    private Map<Student,Character> gradeBook;

    public Classroom(){
        this.students = new ArrayList<>(30);
        this.gradeBook = new HashMap<>(30);
    }

    public Classroom(Integer size){
        this.students = new ArrayList<>(size);
        this.gradeBook = new HashMap<>(size);
    }

    public Classroom(Student[] input){
        this.students = new ArrayList<>(input.length);
        this.gradeBook = new HashMap<>(input.length);
        for (int i = 0; i < input.length; i++) {
            students.add(input[i]);
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
        this.students.add(student);
    }

    public void removeStudent(String firstName, String lastName){
        if(this.students.size() != 0)
        for(int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getFirstName().equals(firstName)
                    && this.students.get(i).getLastName().equals(lastName)) {
                students.remove(i);
            }
        }
    }

    public Student[] getSudentByScore(){
        Student[] returnStudents = new Student[this.students.size()];
        for (int i = 0; i < this.students.size(); i++) {
            returnStudents[i] = this.students.get(i);
        }

        for (int i = 0; i < returnStudents.length; i++) {
            for (int j = i + 1; j < returnStudents.length; j++) {
                if (returnStudents[i].getAverageExamScore() < returnStudents[j].getAverageExamScore()) {
                    Student temp = returnStudents[i];
                    returnStudents[i] = returnStudents[j];
                    returnStudents[j] = temp;
                }
            }
        }

        for (int i = 1; i < returnStudents.length; i++) {
            if(returnStudents[i].getAverageExamScore().equals(returnStudents[i-1].getAverageExamScore())) {
                String studentBeforeLastName = returnStudents[i-1].getLastName().toLowerCase();
                String studentBeforeFirstName = returnStudents[i-1].getFirstName().toLowerCase();
                String studentAfterLastName = returnStudents[i].getLastName().toLowerCase();
                String studentAfterFirstName = returnStudents[i].getFirstName().toLowerCase();
                if (!studentBeforeLastName.equals(studentAfterLastName)) {
                    int counter = 0;
                    while (true) {
                        if (studentBeforeLastName.charAt(counter) > studentAfterLastName.charAt(counter)) {
                            Student temp = returnStudents[i-1];
                            returnStudents[i-1] = returnStudents[i];
                            returnStudents[i] = temp;
                            break;
                        }
                        counter++;
                    }
                } else {
                    int counter = 0;
                    while (true) {
                        if (studentBeforeFirstName.charAt(counter) > studentAfterFirstName.charAt(counter)) {
                            Student temp = returnStudents[i-1];
                            returnStudents[i-1] = returnStudents[i];
                            returnStudents[i] = temp;
                            break;
                        }
                        counter++;
                    }
                }
            }
        }
        return returnStudents;
    }

    public Map<Student,Character> getGradeBook(){
        Student[] averageGrade = getSudentByScore();
        double highestScore = averageGrade[0].getAverageExamScore();
        double lowestScore = averageGrade[averageGrade.length-1].getAverageExamScore();
        int range = (int) (highestScore - lowestScore);
        int a = (int)highestScore - (int) (range * .1);
        int b = (int)highestScore -  (int)(range * .29);
        int c = (int)highestScore -  (int)(range * .50);
        int d = (int)highestScore -  (int)(range * .89);
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getAverageExamScore() < d){
                gradeBook.put(students.get(i), 'F');
            }else if(students.get(i).getAverageExamScore() < c){
                gradeBook.put(students.get(i), 'D');
            }else if(students.get(i).getAverageExamScore() < b){
                gradeBook.put(students.get(i), 'C');
            }else if(students.get(i).getAverageExamScore() < a){
                gradeBook.put(students.get(i), 'B');
            }else {
                gradeBook.put(students.get(i), 'A');
            }
        }

        return gradeBook;
    }
}
