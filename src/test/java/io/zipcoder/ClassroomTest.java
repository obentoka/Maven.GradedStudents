package io.zipcoder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassroomTest {

    @Test
    public void getAverageTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void addStudentTest(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = preEnrollment.toString();

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        for (int i = 0; i < postEnrollment.length; i++) {
            System.out.println("Student Name: " + postEnrollment[i].getFirstName()
            + " " + postEnrollment[i].getLastName());
            System.out.println(postEnrollment[i].toString());
        }
    }

    @Test
    public void removeTest(){
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        classroom.addStudent(student);
        classroom.removeStudent(student.getFirstName(), student.getLastName());

        Integer expectedSize = 0;
        Integer actualSize = classroom.getStudents().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getStudentByScoreTest(){
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores0 = { 100.0, 150.0, 250.0, 0.0 };
        Student student0 = new Student("Aeon", "Hunter", examScores0);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Double[] examScores2 = { 100.0, 150.0, 250.0, 0.0 };
        Student student2 = new Student("Leon", "Bunter", examScores2);
        Double[] examScores3 = { 100.0, 100.0, 100.0, 0.0 };
        Student student3 = new Student("Test", "Are", examScores3);

        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student0);
        Student[] actualStudents = classroom.getSudentByScore();
        for (int i = 0; i < actualStudents.length; i++) {
            System.out.println("Student Name: " + actualStudents[i].getFirstName()
                    + " " + actualStudents[i].getLastName());
            System.out.println(actualStudents[i].toString());
        }
    }
}
