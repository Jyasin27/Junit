package junit5.listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listener implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("----------");
        System.out.println("This test was disabled: " + context.getTestMethod() + " - with reason: " +reason); //go to HTMI report file
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        System.out.println("----------");
        System.out.println("This test was successful" +context.getTestMethod());

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("----------");
        System.out.println("This test was aborted" + cause.getMessage());
        //TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause)
    {
        System.out.println("----------");
        System.out.println("This test failed" + cause.getMessage());
        TestWatcher.super.testFailed(context, cause);
    }
}
