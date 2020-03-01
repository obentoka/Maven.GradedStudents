package io.zipcoder;

import org.junit.Test;

import java.util.Map;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class ClassroomTest {

    private static final Logger LOGGER =
            Logger.getLogger((ClassroomTest.class.getName()));

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

        Integer expectedSize = 1;
        Integer actualSize = classroom.getStudents().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getStudentByScoreTest(){
        int maxNumberOfStudents = 5;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores0 = { 100.0, 150.0, 250.0, 0.0 };
        Student student0 = new Student("Aeon", "Hunter", examScores0);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Double[] examScores2 = { 100.0, 150.0, 250.0, 0.0 };
        Student student2 = new Student("Leon", "Bunter", examScores2);
        Double[] examScores3 = { 100.0, 100.0, 100.0, 0.0 };
        Student student3 = new Student("Test", "Are", examScores3);
        Student[] expectedStudent = {student2, student0, student, student3};

        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student0);
        Student[] actualStudents = classroom.getSudentByScore();
        for (int i = 0; i < actualStudents.length; i++) {
            LOGGER.info("Student Name: " + actualStudents[i].getFirstName()
                    + " " + actualStudents[i].getLastName() + "\n"+
                    actualStudents[i].toString());
        }
        assertEquals(expectedStudent, actualStudents);
    }

    @Test
    public void getGradeBookTest(){
        int maxNumberOfStudents = 5;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores0 = { 100.0, 150.0, 250.0, 0.0 };
        Student student0 = new Student("Aeon", "Hunter", examScores0);
        Double[] examScores = { 100.0, 100.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Double[] examScores2 = { 100.0, 75.0, 250.0, 0.0 };
        Student student2 = new Student("Leon", "Bunter", examScores2);
        Double[] examScores3 = { 100.0, 100.0, 100.0, 0.0 };
        Student student3 = new Student("Test", "Are", examScores3);
        Double[] examScores4 = { 100.0, 150.0, 100.0, 0.0 };
        Student student4 = new Student("Leon", "Bumber", examScores4);


        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student0);
        classroom.addStudent(student4);
        Student[] studentArr = classroom.getStudents();
        Map<Student,Character> grade = classroom.getGradeBook();

        for (int i = 0; i < grade.size(); i++) {
            LOGGER.info(studentArr[i].toString());
            LOGGER.info("" + grade.get(studentArr[i]));
        }
    }
}
