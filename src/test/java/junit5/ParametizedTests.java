package junit5;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParametizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
       @ValueSource() //arguments are 1,5,6
    void intValues(int theParam)  //can only pass one param
    {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @NullAndEmptySource
    //@NullSource //first param is null
    // @EmptySource //shows an empty value

    void stringValues(String theParam)
    {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve, rogers", "captain, marvel", "bucky, barnes"}) //param separated by commas
    void csvSource_StringString(String param1, String param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value = {"steve,32, true", "captain, 21, false", "bucky, 14, true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain america, 'steve,rogers'", "winter soldier," +
            "'bucky, barnes'"})
    void csvSource_StringWithComma(String param1, String param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    void csvSource_StringWithDiffDelimiter(String param1, String param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    //Chap6
    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shopppinglist.csv", "src/test/resources/params/shoppinglist2.csv"},
            numLinesToSkip = 1) //Skip first line of shopping list file as its header
    void csvFileSource_StringDoubleIntStringString(String name, double price, int qt, String uom,
                                                   String provider)
    {
        System.out.println("name = " + name + ", price = " + price +
                ", qt = " + qt + ", uom = " + uom + ", provider = " + provider);
    }
    //changing delimiters
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv",
            numLinesToSkip = 1, delimiterString = "___") //Skip first line of shopping list file as its header
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String name, double price, int qt, String uom,
                                                   String provider)
    {
        System.out.println("name = " + name + ", price = " + price +
                ", qt = " + qt + ", uom = " + uom + ", provider = " + provider);
    }
    //Chap7
    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1)
    {
        System.out.println("param1 = " + param1);
    }

    List<String> sourceString()
        {
            //processing done here
            return Arrays.asList("toamto", "carrot", "cabbage");
        }
    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StringStream(String param1)
    {
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1,double param2 )
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @MethodSource(value = "junit5.ParamProvider#sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1 , double param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }


        Stream<String>sourceStringAsStream()
        {
            //processing
            return Stream.of("beetroot", "apple", "pear");
        }

        List<Arguments> sourceList_StringDouble()
        {
            //processing
            return Arrays.asList(arguments("tomato", 2.0), arguments("carrot", 3.2),
                    arguments("cabbage", 5));
        }


}
