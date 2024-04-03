package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicalRecordDisplay {
    private static final Logger logger = Logger.getLogger(MedicalRecordDisplay.class.getName());
    private static final String DB_URL = "jdbc:mysql://localhost:3306/medical_reports";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Rule#1dontlose";

    public void displayMedicalRecords() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT * FROM medical_reports";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                System.out.println("Medical Records:");
                while (rs.next()) {
                    // Retrieve and display each medical record from the database
                    String medicalRecord = rs.getString("report");
                    System.out.println(medicalRecord);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error displaying medical records from database", e);
        }
    }
}
