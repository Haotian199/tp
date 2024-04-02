package seedu.duke;

import expenditure.ExpenditureList;
import timetable.TimetableList;

import static storage.Storage.readExpenditureFile;
import static storage.Storage.readTimetableFile;

public class CantVasMain {
    public static UI ui;
    private static ExpenditureList expenseList;
    private static TimetableList timetableList;
    private static ProcessCommand processCommand;

    public CantVasMain() {
        ui = new UI();
        expenseList = readExpenditureFile();
        timetableList = readTimetableFile();
        processCommand = new ProcessCommand();
    }

    public void run() {
        UI.printLogo();
        UI.printMotivationQuote();
        UI.printHelpMessage();
        boolean exit;
        do {
            String command = ui.getUserCommand();
            exit = processCommand.userCommand(command, expenseList, timetableList);
        } while (!exit);
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new CantVasMain().run();
    }
}
