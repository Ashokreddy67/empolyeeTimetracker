<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body { font-family: Times New Roman; }
        .container { width: 80%; margin: auto; }
        .section { 
            margin-bottom: 20px; 
            padding: 20px; 
            border-radius: 10px; 
            background-color: #f2f2f2;
        }
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Admin Dashboard</h1>

        <!-- Time Logs Section -->
        <div id="timeLogs" class="section" style="display: block;">
            <h2>Admin Dashboard - Employee Login Status</h2>
            <table>
                <thead>
                    <tr>
                        <th>Log ID</th>
                        <th>Employee ID</th>
                        <th>Log Type</th>
                        <th>Log Time</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        String jdbcURL = "jdbc:mysql://localhost:3306/db2";
                        String jdbcUsername = "root";
                        String jdbcPassword = "Ashok@123";

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                            Statement statement = connection.createStatement();
                            // Updated SQL query to limit results to 12
                            String sql = "SELECT * FROM timelogs ORDER BY LogType DESC LIMIT 12";
                            ResultSet resultSet = statement.executeQuery(sql);
                            while(resultSet.next()) {
                                out.println("<tr>");
                                out.println("<td>" + resultSet.getInt("LogID") + "</td>");
                                out.println("<td>" + resultSet.getString("EmpID") + "</td>");
                                out.println("<td>" + resultSet.getString("LogType") + "</td>");
                                out.println("<td>" + resultSet.getTimestamp("LogTime") + "</td>");
                                out.println("</tr>");
                            }
                            resultSet.close();
                            statement.close();
                            connection.close();
                        } catch (Exception e) {
                            out.println("<tr><td colspan='4'>Exception: " + e.getMessage() + "</td></tr>");
                        }
                    %>
                </tbody>
            </table>
        </div>

        <!-- Login Status Section -->
        <div id="loginStatus" class="section" style="display: none;">
            <h2>Login Status</h2>
            <table>
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Employee Name</th>
                        <th>Login Time</th>
                        <th>Logout Time</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Dynamically populate with login status -->
                    <c:forEach var="status" items="${loginStatusList}">
                        <tr>
                            <td>${status.empID}</td>
                            <td>${status.empName}</td>
                            <td>${status.loginTime}</td>
                            <td>${status.logoutTime}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
