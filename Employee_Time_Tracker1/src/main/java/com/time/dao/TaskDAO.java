package com.time.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/db2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Ashok@123";

    private static final String UPDATE_TASK_SQL = "UPDATE employeetasks SET TaskName = ?, TaskCategory = ?, TaskDate = ?, TimeDuration = ?, Description = ?, ManagerID = ?, ManagerName = ? WHERE EmpID = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean updateTask(Task task) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TASK_SQL)) {
            preparedStatement.setString(1, task.getTaskName());
            preparedStatement.setString(2, task.getTaskCategory());
            preparedStatement.setString(3, task.getTaskDate());
            preparedStatement.setString(4, task.getTimeDuration());
            preparedStatement.setString(5, task.getDescription());
            preparedStatement.setString(6, task.getManagerID());
            preparedStatement.setString(7, task.getManagerName());
            preparedStatement.setString(8, task.getEmpID());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

	public boolean verifyEmpID1(String empID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyEmpID(String empID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addTask(Task task) {
		// TODO Auto-generated method stub
		return false;
	}
}
