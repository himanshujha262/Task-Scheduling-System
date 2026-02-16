import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Project> projects = ProjectDAO.getAllProjects();

        Scheduler.generateSchedule(projects);
    }
}
