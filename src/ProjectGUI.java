import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ProjectGUI {

    private JFrame frame;
    private JTextField titleField, deadlineField, revenueField;
    private JTextArea outputArea;

    public ProjectGUI() {

        frame = new JFrame("ProManage Project Scheduler");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Input Fields
        frame.add(new JLabel("Title:"));
        titleField = new JTextField(20);
        frame.add(titleField);

        frame.add(new JLabel("Deadline (1-5):"));
        deadlineField = new JTextField(5);
        frame.add(deadlineField);

        frame.add(new JLabel("Revenue:"));
        revenueField = new JTextField(10);
        frame.add(revenueField);

        // Buttons
        JButton addButton = new JButton("Add Project");
        JButton viewButton = new JButton("View Projects");
        JButton scheduleButton = new JButton("Generate Schedule");

        frame.add(addButton);
        frame.add(viewButton);
        frame.add(scheduleButton);

        // Output Area
        outputArea = new JTextArea(15, 40);
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea));

        // Button Actions

        addButton.addActionListener((ActionEvent e) -> addProject());

        viewButton.addActionListener((ActionEvent e) -> viewProjects());

        scheduleButton.addActionListener((ActionEvent e) -> generateSchedule());

        frame.setVisible(true);
    }

    private void addProject() {
        try {
            String title = titleField.getText();
            int deadline = Integer.parseInt(deadlineField.getText());
            int revenue = Integer.parseInt(revenueField.getText());

            ProjectDAO. Project(title, deadline, revenue);

            outputArea.setText("✅ Project Added Successfully!\n");

        } catch (Exception ex) {
            outputArea.setText("❌ Invalid Input!\n");
        }
    }

    private void viewProjects() {

        List<Project> projects = ProjectDAO.getAllProjects();

        StringBuilder sb = new StringBuilder("📋 Project List:\n");

        for (Project p : projects) {
            sb.append(p.id).append(" | ")
                    .append(p.title).append(" | Deadline: ")
                    .append(p.deadline).append(" | Revenue: ")
                    .append(p.revenue).append("\n");
        }

        outputArea.setText(sb.toString());
    }

    private void generateSchedule() {

        List<Project> projects = ProjectDAO.getAllProjects();

        outputArea.setText("");

        Scheduler.generateSchedule(projects);
    }

    public static void main(String[] args) {
        new ProjectGUI();
    }
}
