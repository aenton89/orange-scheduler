package org.example.data;

import com.opencsv.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class CSVDataReader {
    // INSTANCE VARIABLES

    private String filePath;
    private List<Person> personList = new ArrayList<>();


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
    public List<Person> getPersonList() {
        return personList;
    }


    // read the CSV file
    public void readCSV(){
        if(filePath.isEmpty() || filePath == null){
            System.out.println("No file specified.");
            return;
        }

        try {
            FileReader fr = new FileReader(filePath);

            CsvToBean<Person> csvToBean = new CsvToBeanBuilder<Person>(fr)
                    .withType(Person.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();

            personList = csvToBean.parse();

            // setup for each person, also delete the null ones
            for(Person p : personList){
                p.setup();

                if (p.isDeletable())
                    personList.remove(p);
            }

        } catch (Exception e) {
            System.out.println("Error reading file.");
            System.out.println(e.getMessage());
        }
    }
}
