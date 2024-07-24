package com.time.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/CreateEmployeeServlet")
public class CreateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int empIdCounter = 100; // Initial counter for Employee ID
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int PASSWORD_LENGTH = 8;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db2";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Ashok@123"; // Update with your database password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String mobileNo = request.getParameter("mobile_no");

        String empId = generateEmpId();
        String password = generatePassword();

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Insert employee details into the database
            String sql = "INSERT INTO Employee (Empid, Name, Password, Role, Email, Dob, Mobile_No) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empId);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, role);
            preparedStatement.setString(5, email);
            preparedStatement.setDate(6, java.sql.Date.valueOf(dob));
            preparedStatement.setString(7, mobileNo);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("empId", empId);
        request.setAttribute("password", password);
        request.setAttribute("name", name);
        request.setAttribute("role", role);
        request.setAttribute("email", email);
        request.setAttribute("dob", dob);
        request.setAttribute("mobile_no", mobileNo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("employee_created.jsp");
        dispatcher.forward(request, response);
    }

    private String generateEmpId() {
        return String.format("%03d", empIdCounter++);
    }

    private String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return password.toString();
    }
}
