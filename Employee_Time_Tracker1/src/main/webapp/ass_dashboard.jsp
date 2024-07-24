<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Associate Manager Dashboard</title>
    <style>
        body { font-family: Times New Roman; }
        .container { width: 80%; margin: auto; }
        .navigation-container {
            margin-bottom: 20px; 
            padding: 20px; 
            border-radius: 10px; 
            display: flex; 
            justify-content: space-around; 
            background-color: #f2f2f2;
        }
        button { 
            padding: 12px 24px; 
            margin: 8px; 
            box-sizing: border-box; 
            background-color: #007BFF; /* Blue color */
            color: white; 
            border: none; 
            cursor: pointer; 
            font-size: 16px;
            border-radius: 20px; /* More curved edges */
            transition: background-color 0.3s, transform 0.3s;
        }
        button:hover { 
            background-color: red; /* Red color on hover */
            transform: scale(1.05); /* Slightly enlarge button */
        }
        button:active { 
            background-color: darkred; /* Darker red color on click */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Associate Manager Dashboard</h1>

        <!-- Navigation Buttons -->
        <div class="navigation-container">
            <button onclick="window.location.href='addTask.jsp'">Add Task</button>
            <button onclick="window.location.href='loginStatus.jsp'">Login Status</button>
            <button onclick="window.location.href='dailyTaskStatus.jsp'">Daily Task Status Chart</button>
            <button onclick="window.location.href='weeklyTaskStatus.jsp'">Weekly Task Status Chart</button>
        </div>
    </div>
</body>
</html>
