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

@WebServlet("/UpdateEmpDetailsServlet")
public class UpdateEmpDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db2";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Ashok@123";

    @Override
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
                String sql = "SELECT EmpID, EmployeeName, Role, MobileNo, Email FROM employeetasks WHERE EmpID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, empID);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    request.setAttribute("empID", rs.getString("EmpID"));
                    request.setAttribute("employeeName", rs.getString("EmployeeName"));
                    request.setAttribute("role", rs.getString("Role"));
                    request.setAttribute("mobileNo", rs.getString("MobileNo"));
                    request.setAttribute("email", rs.getString("Email"));
                    request.getRequestDispatcher("/updateEmpDetails.jsp").forward(request, response);
                } else {
                    out.println("<html><body><h2>No employee found for employee ID " + empID + "</h2></body></html>");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<html><body><h2>Error occurred: " + e.getMessage() + "</h2></body></html>");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empID = request.getParameter("empID");
        String employeeName = request.getParameter("employeeName");
        String role = request.getParameter("role");
        String mobileNo = request.getParameter("mobileNo");
        String email = request.getParameter("email");

        if (empID == null || empID.isEmpty()) {
            out.println("<html><body><h2>Employee ID is required.</h2></body></html>");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                String sql = "UPDATE employeetasks SET EmployeeName = ?, Role = ?, MobileNo = ?, Email = ? WHERE EmpID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, employeeName);
                stmt.setString(2, role);
                stmt.setString(3, mobileNo);
                stmt.setString(4, email);
                stmt.setString(5, empID);
                
                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated > 0) {
                    out.println("<html><body><h2>Employee details updated successfully for employee ID " + empID + "</h2></body></html>");
                } else {
                    out.println("<html><body><h2>No employee found for employee ID " + empID + "</h2></body></html>");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<html><body><h2>Error occurred: " + e.getMessage() + "</h2></body></html>");
            e.printStackTrace();
        }
    }
}
