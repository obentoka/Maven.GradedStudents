package io.zipcoder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassroomTest {

    @Test
    public void constructorTest(){
        String expectedFName = "Von";
        String expectedLName = "Le";
        Double[] expectedExamScore = {80.0, 70.0, 95.0};
        Integer expectedExamAmount = 3;

        Student von = new Student(expectedFName, expectedLName, expectedExamScore);

        String actualFName = von.getFirstName();
        String actualLName = von.getLastName();
        Integer actualExamAmount = von.getNumberOfExamsTaken();

        assertEquals(expectedFName, actualFName);
        assertEquals(expectedLName, actualLName);
        assertEquals(expectedExamAmount, actualExamAmount);
        assertEquals(expectedExamScore[0], von.getExams().get(0));
    }

    @Test
    public void examTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }
}
