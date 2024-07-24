<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.time.dao.Task" %>
<%@ page import="com.time.dao.TaskDAO" %>

<%
    String empID = request.getParameter("empID");
    TaskDAO taskDAO = new TaskDAO();
    Task task = new Task();
    task.setEmpID(empID);
    // Retrieve the task details from the database if needed
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Task</title>
</head>
<body>
    <h1>Update Task</h1>
    <form action="AddTaskServlet" method="post">
        <input type="hidden" name="empID" value="${empID}">

        <label for="taskName">Task Name</label>
        <input type="text" id="taskName" name="taskName" required><br>

        <label for="taskCategory">Task Category</label>
        <input type="text" id="taskCategory" name="taskCategory" required><br>

        <label for="taskDate">Task Date</label>
        <input type="date" id="taskDate" name="taskDate" required><br>

        <label for="timeDuration">Time Duration</label>
        <input type="text" id="timeDuration" name="timeDuration" required><br>

        <label for="description">Description</label>
        <input type="text" id="description" name="description" required><br>

        <label for="managerID">Manager ID</label>
        <input type="text" id="managerID" name="managerID" required><br>

        <label for="managerName">Manager Name</label>
        <input type="text" id="managerName" name="managerName" required><br>

        <button type="submit">Update Task</button>
    </form>
</body>
</html>
