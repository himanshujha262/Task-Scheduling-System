📅 Task Scheduling System

A Task Scheduling System designed to manage, organize, and visualize scheduled tasks efficiently.
The project provides a daily-oriented overview of tasks, helping users quickly identify what needs immediate attention and what is upcoming in the next business days.

🚀 Features

📌 Manage and track scheduled tasks for multiple clients or categories

📅 View tasks due today and in the upcoming business days

🗂️ Hierarchical task display with priority, duration, and description

⚡ Simple execution through a command-line interface

🧾 Configuration-based task storage for easy updates and persistence

🔍 Clear visualization of pending and upcoming work

These capabilities make the scheduler useful for daily planning, workload tracking, and productivity management.

🛠️ Tech Stack

Programming Language: Python

Interface: Command-Line Interface (CLI)

Configuration: INI-based task storage

📂 Project Structure
Task-Scheduling-System/
│──Scheduler.java   # Main scheduler script
│──Main.java
│──Project.java
│── ProjectDAO.java    # Task configuration file   
│── DBConnection.java            
│── README.md          # Project documentation
│── .gitignore

▶️ Getting Started
1️⃣ Clone the repository
git clone https://github.com/himanshujha262/Task-Scheduling-System.git
cd Task-Scheduling-System

2️⃣ Configure tasks

Edit the tasks.ini file and add task details such as:

schedule

priority

estimated duration

description

3️⃣ Run the scheduler
java task_scheduler.java


The program will read configured tasks and display those due today and within the next few business days.

📊 Example Output
📅 Tasks
└── 👥 Client Name
    ├── 📌 Task Title
    │   ├── schedule: everyday
    │   ├── priority: high
    │   ├── estimated_duration: 30m
    │   └── description: Example task


This hierarchical structure helps users quickly understand priorities and timelines.

🎯 Use Cases

Personal task planning

Client-based work tracking

Daily productivity monitoring

Lightweight scheduling without heavy project-management tools

🤝 Contributing

Contributions are welcome!

Fork the repository

Create a new branch

Commit your changes

Submit a pull request

📜 License

This project is open-source and available under the MIT License (or update with your preferred license).

👤 Author

Himanshu Jha
GitHub: https://github.com/himanshujha262
