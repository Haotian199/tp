package seedu.duke;
import motivationalquote.MotivationalQuotes;
import timetable.Days;

import java.util.Scanner;

public class UI {

    private final Scanner in;

    public UI() {
        this.in = new Scanner(System.in);
    }

    public String getUserCommand() {
        return in.nextLine();
    }

    public static void printLogo() {
        System.out.println("   _____            ___      __\n"
                + "  / ____|          | \\ \\    / /\n"
                + " | |     __ _ _ __ | |\\ \\  / /_ _ ___\n"
                + " | |    / _` | '_ \\| __\\ \\/ / _` / __|\n"
                + " | |___| (_| | | | | |_ \\  / (_| \\__ \\\n"
                + "  \\_____\\__,_|_| |_|\\__| \\/ \\__,_|___/\n"
        );
    }

    public static void printHelpMessage() {
        System.out.println("CantVas Help\n"
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
                + "To end the program, type 'exit'");
    }

    public static void printExitMessage() {
        System.out.println("Shutting down... Goodbye!!");
    }

    public static void printMotivationQuote() {
        String quote = MotivationalQuotes.getQuote();
        System.out.println("Here is your motivational quote of the day:");
        System.out.println(quote);
        printLineBreak();
    }

    public static void printLineBreak() {
        System.out.println(" -------------------------------------------------------------\n");
    }

    public static void printTimetableByDay(Days[] timetable) {
        for (int i = 0; i < 24; i ++) {
            if (timetable[i] != null) {
                System.out.println(timetable[i].getClassTime() +
                        " | " + timetable[i].getClassCode() +
                        " | " + timetable[i].getClassLocation());
            }
        }
    }

}
