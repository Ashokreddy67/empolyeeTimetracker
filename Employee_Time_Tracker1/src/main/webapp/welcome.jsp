<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Tracking Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <aside class="sidebar">
            <div class="logo">
                <img src="12.png" alt="Logo">
            </div>
            <nav class="nav">
                <ul>
                    <li><a href="#">Dashboards</a></li>
                    <li><a href="#">Focus</a></li>
                    <li><a href="#">Accounting</a></li>
                    <li><a href="#">Tasks</a></li>
                    <li><a href="#">Jobs</a></li>
                    <li><a href="#">Employees</a></li>
                    <li><a href="#">Organization</a></li>
                    <li><a href="#">Contacts</a></li>
                    <li><a href="#">Goals</a></li>
                    <li><a href="#">Reports</a></li>
                </ul>
            </nav>
        </aside>
        <main class="main-content">
            <header class="header">
                <div class="header-left">
                    <button class="create-btn" onclick="openModal()">Create</button>
                    <div class="filter">
                        <select>
                            <option>All Projects</option>
                        </select>
                    </div>
                </div>
                <div class="header-right">
                    <span class="username">Ashok Reddy</span>
                 
                </div>
            </header>
            <section class="content">
                <h2>Task Tracking for Employees</h2>
                <div class="tasks-list">
                    <h3>Tasks</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Employee</th>
                                <th>Role</th>
                                <th>Project</th>
                                <th>Date</th>
                                <th>Time</th>
                                <th>Category</th>
                                <th>Description</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                  
                        </tbody>
                    </table>
                </div>
                <div class="charts">
                    <h3>Charts</h3>
                    <div class="chart">
                        <h4>Daily Task Distribution (Pie Chart)</h4>
                        <img src="path/to/daily-pie-chart.png" alt="Daily Task Distribution">
                    </div>
                    <div class="chart">
                        <h4>Weekly Task Distribution (Bar Chart)</h4>
                        <img src="path/to/weekly-bar-chart.png" alt="Weekly Task Distribution">
                    </div>
                    <div class="chart">
                        <h4>Monthly Task Distribution (Bar Chart)</h4>
                        <img src="path/to/monthly-bar-chart.png" alt="Monthly Task Distribution">
                    </div>
                </div>
            </section>
        </main>
    </div>

    <!-- Modal -->
    <div id="taskModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h3>Add Task</h3>
            <form class="task-form">
                <input type="text" placeholder="Employee Name" required>
                <input type="text" placeholder="Role" required>
                <input type="text" placeholder="Project" required>
                <input type="date" placeholder="Date" required>
                <input type="time" placeholder="Start Time" required>
                <input type="time" placeholder="End Time" required>
                <input type="text" placeholder="Task Category" required>
                <textarea placeholder="Description" required></textarea>
                <button type="submit">Add Task</button>
            </form>
        </div>
    </div>

    <script src="script.js"></script>
</body>
</html>
