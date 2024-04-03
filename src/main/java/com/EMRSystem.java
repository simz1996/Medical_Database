package com;

import java.util.List;

public class EMRSystem {
    public static void main(String[] args) {
        String filePath = "src/resources/med_data.csv";

        // Extract medical records
      
        MedicalRecordExtractor extractor = new MedicalRecordExtractor();
        List<String[]> medicalRecords = extractor.extractFromCSV(filePath);

        // Handle irregular data
        IrregularDataHandler dataHandler = new IrregularDataHandler();
        for (String[] medicalReport : medicalRecords) {
            dataHandler.handleIrregularData(medicalReport);
        }

        // Store medical reports in database
        for (String[] medicalReport : medicalRecords) {
            DatabaseManager.storeMedicalReport(medicalReport);
        }

        // Display medical records from the database
        MedicalRecordDisplay display = new MedicalRecordDisplay();
           display.displayMedicalRecords();
    }
}


