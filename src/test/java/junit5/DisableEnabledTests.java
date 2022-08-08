package junit5;

import junit5.listeners.Listener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@ExtendWith(Listener.class)
public class DisableEnabledTests {

    @Test
    @Disabled(value = "Disabled for demo of @Disabled") //no condition
    void firstTest()
    {
        System.out.println("This is the 1st Test method");
    }
    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled for demo of " + "@DisabledOnOs")//disabled when on windows
    void secondTest()
    {
        System.out.println("This is the 2nd Test method");
    }
    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging", //must look at vidoe chap10
    disabledReason = "DisabledIfSystemProperty")
    void thirdTest()
    {
        System.out.println("This is the 3rd Test method");
    }
    @Test
    @DisabledIf(value = "provider", disabledReason = "Disabled for demo of DisabledIf")
    void forthTest()
    {
        System.out.println("This is the 4th Test method");

    }

    @Test
    void fifthTest()
    {
        System.out.println("This is the 5th Test method");
    }
    boolean provider(){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.TUESDAY);

    }

}
