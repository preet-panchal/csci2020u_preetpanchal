package org.apache.commons.csv;

import java.io.*;
import org.apache.commons.csv.*;
// import static org.apache.commons.csv.Token.Type.*;

public class CSVDemo {
    public static void main(String[] args) {
        try {
            Reader in = new FileReader("data.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("First Name", "Last Name", "SID", "Grade").parse(in);
            for (CSVRecord record: records) {
                String lastName = record.get("Last Name");
                String firstName = record.get("First Name");
                String grade = record.get("Grade");
                System.out.println(firstName + " " + lastName + " (" + grade + ")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
