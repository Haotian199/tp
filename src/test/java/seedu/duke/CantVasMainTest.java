package seedu.duke;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CantVasMainTest {

    @Test
    public void testInitialization() {
        CantVasMain cantVasMain = new CantVasMain();
        assertNotNull(CantVasMain.ui);
    }

    @Test
    public void testRunMethod() {
        CantVasMain cantVasMain = new CantVasMain();
        CantVasMain.ui = new StubUI();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        cantVasMain.run();

        assertTrue(outContent.toString().contains("Shutting down... Goodbye!!"));
    }

    // StubUI class to simulate user input
    private static class StubUI extends UI {
        @Override
        public String getUserCommand() {
            return "exit";
        }
    }
}
