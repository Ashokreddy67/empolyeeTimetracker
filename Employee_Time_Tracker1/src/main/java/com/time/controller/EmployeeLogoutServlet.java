package com.time.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeLogoutServlet")
public class EmployeeLogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empID = request.getParameter("EmpID");

        // Database connection parameters
        String jdbcURL = "jdbc:mysql://localhost:3306/db2";
        String jdbcUsername = "root";
        String jdbcPassword = "Ashok@123";

        String sql = "INSERT INTO timelogs (EmpID, LogType, LogTime) VALUES (?, 'LOGOUT', ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, empID);
            statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee logout logged successfully.");
                // Redirect to login page or any other page
                response.sendRedirect("login.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
