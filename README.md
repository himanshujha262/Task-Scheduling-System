📅 Task Scheduling System

A Java-based Task Scheduling System designed to efficiently manage, organize, and visualize scheduled tasks.
The application provides a day-focused overview, enabling users to quickly identify urgent tasks and monitor upcoming work across business days.

This lightweight scheduler is ideal for daily planning, productivity tracking, and client-based task management without relying on heavy project-management tools.

🚀 Key Features

📌 Manage and track tasks across multiple clients or categories

📅 Instantly view tasks due today and in upcoming business days

🗂️ Hierarchical task structure including priority, duration, and description

⚡ Lightweight command-line execution for fast interaction

🧾 Configuration-driven storage for easy updates and persistence

🔍 Clear visibility of pending and upcoming workloads

🛠️ Tech Stack

Programming Language: Java

Interface: Command-Line Interface (CLI)

Configuration Storage: INI-based task configuration

📂 Project Structure
Task-Scheduling-System/
│
├── Scheduler.java        # Core scheduling logic
├── Main.java             # Application entry point
├── Project.java          # Task/Project model
├── ProjectDAO.java       # Data handling & persistence
├── DBConnection.java     # Database connection setup
├── README.md             # Documentation
└── .gitignore

▶️ Getting Started
1️⃣ Clone the Repository
git clone https://github.com/himanshujha262/Task-Scheduling-System.git
cd Task-Scheduling-System

2️⃣ Configure Tasks

Edit the tasks.ini file and define:

schedule

priority

estimated duration

description

3️⃣ Run the Scheduler
java task_scheduler.java


The system will read configured tasks and display those due today and within the next business days.

📊 Example Output
📅 Tasks
└── 👥 Client Name
    ├── 📌 Task Title
    │   ├── schedule: everyday
    │   ├── priority: high
    │   ├── estimated_duration: 30m
    │   └── description: Example task


This hierarchical visualization makes it easy to understand priorities, timelines, and workload distribution at a glance.

🎯 Use Cases

Personal daily task planning

Client-based work tracking

Productivity and workload monitoring

Lightweight scheduling without complex PM tools

🤝 Contributing

Contributions are welcome!

Fork the repository

Create a new feature branch

Commit your changes

Submit a pull request

👤 Author

Himanshu Jha
GitHub → https://github.com/himanshujha262
