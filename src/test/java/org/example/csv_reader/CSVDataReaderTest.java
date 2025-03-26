package org.example.csv_reader;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CSVDataReaderTest {

    @Test
    void testReadCSV() {
        // Ścieżka do testowego pliku CSV
        String filePath = "test_files/dane_testowe_orange.csv";

        // Tworzymy obiekt czytnika i ustawiamy plik
        CSVDataReader reader = new CSVDataReader(filePath);

        // Wywołujemy metodę readCSV()
        reader.readCSV();

        // Jeśli nie ma wyjątków, test przechodzi
        assertTrue(true);
    }
}
