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
        assertEquals(expectedLName, actualFName);
        assertEquals(expectedExamAmount, actualExamAmount);
        assertEquals(expectedExamScore[0], von.getExamScores().get(0));
    }
}
