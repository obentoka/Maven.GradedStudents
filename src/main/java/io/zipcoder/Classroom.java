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
                students.add(null);
            }
        }
    }

    public Student[] getSudentByScore(){
        Student[] returnStudents = new Student[this.students.size()];
        List<Student> sortedStudents = students;
        CompareStudents byAverageLastNameFirstName = new CompareStudents();

        Collections.sort(sortedStudents, byAverageLastNameFirstName);

        for (int i = 0; i < sortedStudents.size(); i++) {
            returnStudents[i] = sortedStudents.get(i);
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
