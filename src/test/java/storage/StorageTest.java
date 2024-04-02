package storage;

import expenditure.ExpenditureList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import timetable.TimetableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StorageTest {
    private static final Path TEST_DIRECTORY = Paths.get("data");
    private static final Path EXPENDITURE_FILE_PATH = TEST_DIRECTORY.resolve("expenditure.txt");
    private static final Path TIMETABLE_FILE_PATH = TEST_DIRECTORY.resolve("timetable.txt");

    @BeforeAll
    public static void setup() throws IOException {
        Files.createDirectories(TEST_DIRECTORY);

        // Create sample expenditure file for testing
        List<String> expenditureLines = Arrays.asList(
                "lunch | FOOD | 10.0 | 12.12.2012",
                "dinner | FOOD | 15.0 | 11.11.2011",
                "book for dummies | BOOK | 134.0 | 11.11.2011",
                "something | NA | 1290.0 | 10.10.2010"
        );
        Files.write(EXPENDITURE_FILE_PATH, expenditureLines);

        // Create sample timetable file for testing
        List<String> timetableLines = Arrays.asList(
                "1 | cg2023 | 1 | 1 | c1",
                "2 | ee2026 | 1 | 7 | e9",
                "1 | cs2113 | 1 | 4 | 12"
        );
        Files.write(TIMETABLE_FILE_PATH, timetableLines);
    }

    @Test
    public void testReadExpenditureFile() {
        ExpenditureList expenses = Storage.readExpenditureFile();
        assertNotNull(expenses);
        assertEquals(4, ExpenditureList.expenditureCount);
    }

    @Test
    public void testReadTimetableFile() {
        TimetableList timetable = Storage.readTimetableFile();
        assertNotNull(timetable);
        assertEquals(1, TimetableList.classCount);
    }

    @Test
    public void testWriteToFile() {
        ExpenditureList expenditureList = new ExpenditureList();
        ExpenditureList.addExpenditure(
                "d/ movie t/ ENTERTAINMENT amt/ 15.0 date/ 01.01.2014", true);

        new TimetableList();
        TimetableList.addClass(
                "day/ 1 code/ cde2501 time/ 12 duration/ 1 location/ room 1", true);
        Storage.writeToFile(expenditureList);

        ExpenditureList readExpenditureList = Storage.readExpenditureFile();
        assertNotNull(readExpenditureList);
        assertEquals(1, ExpenditureList.expenditureCount);
        assertEquals(1, TimetableList.classCount);
        assertEquals("movie | ENTERTAINMENT | 15.0 | 01.01.2014",
                readExpenditureList.getExpenditure(0).toStringStorage());
    }

    @Test
    public void testCreateNewFile() {
        boolean expenditureFileExistsBefore = Files.exists(EXPENDITURE_FILE_PATH);
        boolean timetableFileExistsBefore = Files.exists(TIMETABLE_FILE_PATH);

        Storage.createNewFile("expenditure");
        Storage.createNewFile("timetable");

        boolean expenditureFileExistsAfter = Files.exists(EXPENDITURE_FILE_PATH);
        boolean timetableExistsAfter = Files.exists(TIMETABLE_FILE_PATH);

        assertTrue(expenditureFileExistsBefore);
        assertTrue(expenditureFileExistsAfter);
        assertTrue(timetableFileExistsBefore);
        assertTrue(timetableExistsAfter);
    }


}
