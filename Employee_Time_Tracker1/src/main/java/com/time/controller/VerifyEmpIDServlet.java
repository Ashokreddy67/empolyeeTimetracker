package com.time.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VerifyEmpIDServlet")
public class VerifyEmpIDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db2";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Ashok@123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empID = request.getParameter("empID");

        if (empID == null || empID.isEmpty()) {
            out.println("<html><body><h2>Employee ID is required.</h2></body></html>");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                String sql = "SELECT Empid, name, password, role, email, dob, mobile_no FROM Employee WHERE Empid = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, empID);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    request.setAttribute("empID", rs.getString("Empid"));
                    request.setAttribute("name", rs.getString("Name"));
                    request.setAttribute("password", rs.getString("Password"));
                    request.setAttribute("role", rs.getString("Role"));
                    request.setAttribute("mobileNo", rs.getString("Mobile_No"));
                    request.setAttribute("email", rs.getString("Email"));
                    request.setAttribute("dob", rs.getDate("Dob"));
                    request.getRequestDispatcher("/displayEmpDetails.jsp").forward(request, response);
                } else {
                    out.println("<html><body><h2>No employee found for Employee ID " + empID + "</h2></body></html>");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<html><body><h2>Error occurred: " + e.getMessage() + "</h2></body></html>");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
