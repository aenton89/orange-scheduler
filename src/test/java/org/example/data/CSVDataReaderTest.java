package org.example.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CSVDataReaderTest {

    @Test
    void testReadCSV() {
        String filePath = "test_files/dane_testowe_orange_zmiany.csv";
        CSVDataReader reader = new CSVDataReader(filePath);

        reader.readCSV();

        // print the list of persons
        reader.getPersonList().forEach(System.out::println);

        // later add idk some assertions for the list
        assertTrue(true);
        assertTrue(reader.getPersonList().size() == 21);
    }
}
