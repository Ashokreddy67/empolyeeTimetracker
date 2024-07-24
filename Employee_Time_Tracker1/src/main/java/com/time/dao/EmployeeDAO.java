package com.time.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db2";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Ashok@123";

    public void insertEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (name, password, role, email, dob, mobile_no) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getPassword());
            stmt.setString(3, employee.getRole());
            stmt.setString(4, employee.getEmail());
            stmt.setDate(5, java.sql.Date.valueOf(employee.getDob()));
            stmt.setString(6, employee.getMobileNo());

            stmt.executeUpdate();
        }
    }
}
