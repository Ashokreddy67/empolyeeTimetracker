<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Employee Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }
        input[type="text"],
        input[type="email"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
        }
        input[type="text"]:focus,
        input[type="email"]:focus {
            border-color: #4CAF50;
            outline: none;
        }
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box;
        }
        .button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Employee Details</h2>
        <form action="UpdateEmpDetailsServlet" method="post">
            <label for="empID">Employee ID:</label>
            <input type="text" id="empID" name="empID" value="${empID}" readonly><br>
    
            <label for="employeeName">Employee Name:</label>
            <input type="text" id="employeeName" name="employeeName" value="${employeeName}" required><br>
    
            <label for="role">Role:</label>
            <input type="text" id="role" name="role" value="${role}" required><br>
    
            <label for="mobileNo">Mobile No:</label>
            <input type="text" id="mobileNo" name="mobileNo" value="${mobileNo}" required pattern="[0-9]{10}" title="Please enter a valid 10-digit mobile number"><br>
    
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${email}" required><br>
    
            <input type="submit" value="Update" class="button">
        </form>
    </div>
</body>
</html>
