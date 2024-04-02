package seedu.duke;

import expenditure.ExpenditureList;
import storage.Storage;
import gpa.GPACommand;
import gc.GC;
import timetable.TimetableList;
import timetable.TimetableParser;

public class ProcessCommand {

    public void processUserCommand(String command) {
        String[] commandParts = command.substring(2).trim().split("/", 2);
        if (commandParts.length < 2) {
            System.out.println("Incomplete command!");
            return;
        }

        String action = commandParts[0].trim();
        String actionDetails = commandParts[1].trim();

        switch (action) {
        case "add":
            ExpenditureList.addExpenditure(actionDetails,true);
            break;
        case "del":
            try {
                int index = Integer.parseInt(actionDetails);
                ExpenditureList.deleteExpenditure(index);
            } catch (NumberFormatException e) {
                System.out.println("Invalid index format for deletion.");
            }
            break;

        default:
            System.out.println("Unknown function: " + action);
            break;
        }
    }

    public boolean userCommand(String input, ExpenditureList expenses, TimetableList timetable) {
        assert input != null;
        String command;
        int index = input.indexOf(" ");
        if (index != -1) {
            command = input.substring(0, index).trim().toLowerCase();
        } else {
            command = input.trim().toLowerCase();
        }
        switch (command) {
        case "gpa":
            GPACommand.processGPACommand();
            UI.printHelpMessage();
            break;
        case "gc":
            GC.main();
            break;
        case "exit":
            UI.printExitMessage();
            Storage.writeToFile(expenses);
            return true;
        case "list":
            ExpenditureList.listExpenses();
            break;
        case "clearlist":
            ExpenditureList.clearlist();
            break;
        case "help":
            UI.printHelpMessage();
            break;
        case "tt/":
            TimetableParser.parseTimetable(input);
            break;
        case "e/":
            processUserCommand(input);
            break;
        default:
            if (input.startsWith("view -m ")) {
                String monthYear = input.length() > "view -m ".length() ?
                        input.substring("view -m ".length()).trim() : "";
                if (!monthYear.isEmpty()) {
                    ExpenditureList.listExpensesByMonth(monthYear);
                } else {
                    System.out.println("Please provide a month and year in MM.YYYY format after 'view -m'.");
                }
            } else if (input.startsWith("view -y ")) {
                String year = input.length() > "view -y ".length() ?
                        input.substring("view -y ".length()).trim() : "";
                if (!year.isEmpty()) {
                    ExpenditureList.listExpensesByYear(year);
                } else {
                    System.out.println("Please provide a year in YYYY format after 'view -y'.");
                }
            } else if (input.startsWith("view -t ")) {
                index = input.indexOf("-t");
                String type = input.substring(index + 2).toUpperCase().trim();
                ExpenditureList.listExpensesByType(type);
            } else {
                System.out.println("Unknown command. Please try again! Type 'help' for more information!");
            }
            break;
        }
        return false;
    }


}
