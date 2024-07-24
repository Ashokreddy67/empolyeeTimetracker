package com.time.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssLoginServlet")
public class AssLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establish a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "Ashok@123");
            
            // Prepare the SQL query
            String sql = "SELECT * FROM associate_manager WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            // Execute the query
            ResultSet rs = stmt.executeQuery();
            
            // Check if a matching record was found
            if (rs.next()) {
                response.sendRedirect("ass_dashboard.jsp");
            } else {
                out.println("<h1>Login failed. Invalid username or password.</h1>");
                out.println("<a href='login.html'>Try again</a>");
            }
            
            // Close the connection
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>Database connection problem.</h1>");
            out.println("<a href='login.html'>Try again</a>");
        }
    }
}
