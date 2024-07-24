<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Dashboard</title>
    <style>
        body {
            font-family: 'Times New Roman', serif;
            background-color: #f4f4f4;
        }
        .dashboard {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            margin-top: 50px;
        }
        .dashboard h2 {
            margin-bottom: 20px;
        }
        .dashboard form {
            display: flex;
            flex-direction: column;
        }
        .dashboard label {
            margin-bottom: 10px;
        }
        .dashboard input[type="submit"] {
            padding: 10px;
            font-size: 16px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            width: 50%;
            margin: 10px 0;
        }
        .dashboard input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .message {
            margin-top: 20px;
            text-align: center;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="dashboard">
        <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
        <form action="EmployeeLoginServlet" method="post">
            <input type="hidden" name="EmpID" value="<%= session.getAttribute("empID") %>">
            <input type="submit" value="start">
        </form>
        <form action="EmployeeLogoutServlet" method="post">
            <input type="hidden" name="EmpID" value="<%= session.getAttribute("empID") %>">
            <input type="submit" value="Log Out">
        </form>
        <div class="message">
            <% 
                String message = (String) request.getAttribute("message");
                if (message != null) {
                    out.println(message);
                }
            %>
        </div>
    </div>
</body>
</html>
