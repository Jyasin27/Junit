package junit5;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.w3c.dom.ls.LSOutput;

public class AssumptionsTest {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6}) //arguments are 1,5,6
    void intValues(int theParam)  //can only pass one param
    {
        Assumptions.assumeTrue(theParam > 4); //boolean value
        System.out.println("theParam = " + theParam);
    }
    @ParameterizedTest
    @CsvSource(value = {"steve, rogers", "captain, marvel", "bucky, barnes"}) //param separated by commas
    void csvSource_StringString(String param1, String param2)
    {
        Assumptions.assumeFalse(param1.equals("steve"), "The assumption failed for the " + "following param2: "
        + param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value = {"steve,32, true", "captain, 21, false", "bucky, 14, true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3)
    {
        Assumptions.assumingThat(param2 > 20, () -> System.out.println("This code ran"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
}
