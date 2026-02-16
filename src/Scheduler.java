import java.util.*;

public class Scheduler {

    static final int MAX_DAYS = 5;

    public static void generateSchedule(List<Project> projects) {

        // Sort by revenue descending
        projects.sort((a, b) -> b.revenue - a.revenue);

        Project[] schedule = new Project[MAX_DAYS];
        boolean[] occupied = new boolean[MAX_DAYS];

        int totalRevenue = 0;

        for (Project project : projects) {

            // Try assigning to latest available slot before deadline
            for (int day = Math.min(MAX_DAYS, project.deadline) - 1; day >= 0; day--) {

                if (!occupied[day]) {
                    schedule[day] = project;
                    occupied[day] = true;
                    totalRevenue += project.revenue;
                    break;
                }
            }
        }

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        System.out.println("\n📅 Weekly Schedule:");

        for (int i = 0; i < MAX_DAYS; i++) {
            if (schedule[i] != null) {
                System.out.println(days[i] + " → " +
                        schedule[i].title +
                        " (Revenue: " + schedule[i].revenue + ")");
            } else {
                System.out.println(days[i] + " → No Project");
            }
        }

        System.out.println("\n💰 Total Revenue: " + totalRevenue);
    }
}
