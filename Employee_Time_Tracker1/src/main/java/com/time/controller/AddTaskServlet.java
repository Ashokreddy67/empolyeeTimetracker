package com.time.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.time.dao.Task;
import com.time.dao.TaskDAO;

@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empID = request.getParameter("empID");
        String taskName = request.getParameter("taskName");
        String taskCategory = request.getParameter("taskCategory");
        String taskDate = request.getParameter("taskDate");
        String timeDuration = request.getParameter("timeDuration");
        String description = request.getParameter("description");
        String managerID = request.getParameter("managerID");
        String managerName = request.getParameter("managerName");

        TaskDAO taskDAO = new TaskDAO();

        // Verify if the EmpID exists
        boolean empIDExists = taskDAO.verifyEmpID(empID);

        if (empIDExists) {
            Task task = new com.time.dao.Task();
            task.setEmpID(empID);
            task.setTaskName(taskName);
            task.setTaskCategory(taskCategory);
            task.setTaskDate(taskDate);
            task.setTimeDuration(timeDuration);
            task.setDescription(description);
            task.setManagerID(managerID);
            task.setManagerName(managerName);

            boolean success = taskDAO.addTask(task);

            if (success) {
                response.sendRedirect("taskSuccess.jsp");
            } else {
                response.sendRedirect("taskError.jsp");
            }
        } else {
            response.sendRedirect("empIDError.jsp"); // Page to show error if EmpID does not exist
        }
    }
}
