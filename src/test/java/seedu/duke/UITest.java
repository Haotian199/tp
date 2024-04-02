package seedu.duke;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UITest {

    @Test
    void printHelpMessage() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String expectedOutput = "CantVas Help\n"
                + "To input expenses, use format:\n"
                + "<< e/ add/ d/ <description> amt/ <cost> date/ <dd.mm.yyyy> >>\n"
                + "To input expenses with type, use format:\n"
                + "<< e/ add/ d/ <description> t/ <type> amt/ <cost> date/ <dd.mm.yyyy> >>\n"
                + "To delete saved expenses, use format:\n<< e/ del/ <index> >>\n"
                + "To clear the entire expenditure list, use format: \n<< clearlist >>\n"
                + "To List saved expenses, use format:\n<< list >>\n"
                + "To view saved expenses by month, use format:\n<< view -m <mm.yyyy> >>\n"
                + "To view saved expenses by year, use format:\n<< view -y <yyyy> >>\n"
                + "To view saved expenses by type, use format:\n<< view -t <type> >>\n"
                + " -------------------------------------------------------------\n"
                + "To input class to timetable, use format:\n"
                + "<< tt/ add/ day/ <day> code/ <classCode> time/ <hh> duration/ <duration> location/ <location> >>\n"
                + "To delete saved class, use format:\n"
                + "<< tt/ del/ day/ <day> time/ <hh> >>\n"
                + " -------------------------------------------------------------\n"
                + "To Use gpa calculator, type 'gpa' to continue\n"
                + "To end the program, type 'exit'";

        UI.printHelpMessage();
        String printedOutput = outputStreamCaptor.toString().trim();
        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    void printMotivationQuote() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        UI.printMotivationQuote();
        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("Here is your motivational quote of the day:"));
    }

}
