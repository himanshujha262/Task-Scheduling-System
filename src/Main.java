import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProjectDAO dao = new ProjectDAO();
        Scheduler scheduler = new Scheduler();

        while (true) {

            System.out.println("\n====== ProManage Project Scheduler ======");
            System.out.println("1. Add Project");
            System.out.println("2. View All Projects");
            System.out.println("3. Generate This Week Schedule");
            System.out.println("4. Revenue Comparison (This vs Next Week)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter project title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter deadline: ");
                    int deadline = sc.nextInt();

                    System.out.print("Enter revenue: ");
                    double revenue = sc.nextDouble();

                    dao.addProject(new Project(title, deadline, revenue));
                }

                case 2 -> {
                    List<Project> projects = dao.getAllProjects();

                    if (projects.isEmpty()) {
                        System.out.println("\n⚠ No projects found.");
                    } else {
                        System.out.println("\n📂 All Projects:");
                        projects.forEach(System.out::println);
                    }
                }

                case 3 -> {
                    List<Project> all = dao.getAllProjects();
                    List<Project> thisWeek = scheduler.getThisWeekProjects(all);
                    List<Project> optimal = scheduler.generateOptimalSchedule(thisWeek);

                    scheduler.printWeekSchedule("This Week Schedule", optimal);
                }

                case 4 -> {
                    List<Project> all = dao.getAllProjects();

                    List<Project> thisWeek =
                            scheduler.generateOptimalSchedule(
                                    scheduler.getThisWeekProjects(all));

                    List<Project> nextWeek =
                            scheduler.generateOptimalSchedule(
                                    scheduler.getNextWeekProjects(all));

                    scheduler.printWeekSchedule("This Week", thisWeek);
                    scheduler.printWeekSchedule("Next Week", nextWeek);

                    double diff = scheduler.totalRevenue(thisWeek)
                            - scheduler.totalRevenue(nextWeek);

                    System.out.println("\n📊 Revenue Difference: ₹" + diff);
                }

                case 5 -> {
                    System.out.println("👋 Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
