package com.time.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empID = request.getParameter("empid");
        String password = request.getParameter("password");

        // JDBC connection parameters
        String jdbcURL = "jdbc:mysql://localhost:3306/db2";
        String jdbcUsername = "root";
        String jdbcPassword = "Ashok@123";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            // Prepare a statement to check the credentials
            String sql = "SELECT * FROM employeetasks WHERE EmpID = ? AND Password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, empID);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Credentials are correct
                HttpSession session = request.getSession();
                session.setAttribute("empID", empID);
                session.setAttribute("empName", rs.getString("EmployeeName"));
                response.sendRedirect("employee_dashboard.jsp"); // Redirect to a welcome page or dashboard
            } else {
                // Credentials are incorrect
                response.sendRedirect("login.jsp?error=1"); // Redirect back to login page with error
            }

            // Close the resources
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=2"); // Redirect back to login page with error
        }
    }
}
