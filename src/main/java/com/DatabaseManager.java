package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {
    private static final Logger logger = Logger.getLogger(DatabaseManager.class.getName());
    private static final String DB_URL = "jdbc:mysql://localhost:3306/medical_reports";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Rule#1dontlose";

    // Explicitly load the MySQL JDBC driver class
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "MySQL JDBC Driver not found", e);
            throw new RuntimeException("Failed to load MySQL JDBC Driver", e);
        }
    }

    public static void storeMedicalReport(String[] medicalReport) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            createTableIfNotExists(conn); // Ensure the table exists before storing the report
            String sql = "INSERT INTO medical_reports (report) VALUES (?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, String.join(",", medicalReport));
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error storing medical report in database", e);
        }
    }

    private static void createTableIfNotExists(Connection conn) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS medical_reports (id INT AUTO_INCREMENT PRIMARY KEY, report TEXT)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating medical_reports table", e);
        }
    }
}
