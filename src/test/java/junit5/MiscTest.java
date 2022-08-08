package junit5;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class MiscTest {

    @Test
    @Timeout(5) // or use: value = 5, unit = TimeUnit.MINUTES
    void timeout() throws InterruptedException //when a test runs too long, we can end it
    {
        System.out.println("This is the test with the timeout ");
        //to see how the test runs if it takes longer
        Thread.sleep(6000);
    }

    @Test
    @Timeout(90)
    @DisplayName("This is the nice method")
    @Tag("theTag")  // Can replace all these above lines of code with one
    void annotatedMethod()
    {
        System.out.println("This is the annotated method");
    }

    @MyAnnotation
    void annotatedMethod2()
    {
        System.out.println("This is the customed annotated method");
       // Thread.sleep(3000);
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest
    {
        @BeforeAll
        void beforeAll()
        {
            System.out.println("Before All in nested test");
        }
        @Test
        void nestedTestMethod()
        {
            System.out.println("Nested test method");
        }
    }
}
