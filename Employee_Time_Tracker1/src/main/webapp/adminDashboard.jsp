<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.*, javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: 'Times New Roman', serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .header h1 {
            margin: 0;
            font-size: 36px;
        }
        .header a {
            text-decoration: none;
            color: #007BFF;
            font-size: 18px;
        }
        .dashboard {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin: 20px;
        }
        .dashboard .box {
            flex: 1 1 30%;
            margin: 10px;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            text-align: center;
        }
        .dashboard .box a {
            text-decoration: none;
            color: #007BFF;
            font-size: 20px;
        }
        .dashboard .box a:hover {
            text-decoration: underline;
        }
        .time-logs {
            margin-top: 30px;
        }
        .time-logs table {
            width: 100%;
            border-collapse: collapse;
        }
        .time-logs th, .time-logs td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        .time-logs th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>ADMIN DASHBOARD</h1>
        <a href="LOGOUT.jsp">Logout</a>
    </div>
    <div class="dashboard">
        <div class="box">
            <a href="createEmployee.jsp">Create Employee</a>
        </div>
        <div class="box">
            <a href="editEmployee.jsp">Edit Employee</a>
        </div>
        <div class="box">
            <a href="deleteEmployee.jsp">Delete Employee</a>
        </div>
        <div class="box">
            <a href="Reports.jsp">Reports</a>
        </div>
    </div>
</body>
</html>
