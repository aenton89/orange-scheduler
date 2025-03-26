package org.example.csv_reader;

import com.opencsv.*;
import java.io.FileReader;
import java.util.List;

public class CSVDataReader {
    // INSTANCE VARIABLES

    private String filePath;


    // METHODS

    // constructors
    public CSVDataReader() {
        setFile("");
    }
    public CSVDataReader(String file) {
        this.filePath = file;
    }


    // getters and setters
    public String getFile() {
        return filePath;
    }
    public void setFile(String file) {
        this.filePath = file;
    }


    // read the CSV file
    public void readCSV(){
        if(filePath.equals("")){
            System.out.println("No file specified.");
            return;
        }

        try {
            FileReader fr = new FileReader(filePath);

            // for semi-colon separated values
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            CSVReader csvReader = new CSVReaderBuilder(fr)
                    .withCSVParser(parser)
                    .build();

            // read all data at once
            List<String[]> allData = csvReader.readAll();

            // for now just print
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
}
