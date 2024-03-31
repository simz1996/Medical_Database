package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicalRecordExtractor {
    private static final Logger logger = Logger.getLogger(MedicalRecordExtractor.class.getName());

    public List<String[]> extractFromCSV(String filePath) {
        List<String[]> medicalRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Treat each line as a separate medical report
                // Split the line based on the CSV delimiter (e.g., comma)
                String[] fields = line.split(","); 
                medicalRecords.add(fields); // Add the fields as a medical report
            }
            logger.info("Data extracted successfully from CSV file: " + filePath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to extract data from CSV file: " + filePath, e);
        }

        return medicalRecords;
    }
}
