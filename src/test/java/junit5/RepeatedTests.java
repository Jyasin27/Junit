package junit5;

import org.junit.jupiter.api.*;

import java.lang.annotation.Repeatable;

public class RepeatedTests {

    @RepeatedTest(5) //run code x5
    void firstRepeatedMethod()
    {
        System.out.println("We are repeating this test");
    }
    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}" + "Total is: {totalRepetitions}")
    @DisplayName("This is a repeated Test method")
    void secondRepeatedMethod()
    {
        System.out.println("We are repeating a 2nd test");
    }

    @RepeatedTest(3)
    void thirdRepeatedMethod(RepetitionInfo repetitionInfo)
    {
         System.out.println("This code will run at each repetition");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 3,() ->
            System.out.println("This code only runs for repetition 3"));
    }

}
