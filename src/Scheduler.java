import java.util.*;

public class Scheduler {

    // Deadline ≤ 4 → This week
    // Deadline > 4 → Next week

    public List<Project> getThisWeekProjects(List<Project> projects) {
        List<Project> list = new ArrayList<>();
        for (Project p : projects) {
            if (p.getDeadline() <= 4) {
                list.add(p);
            }
        }
        return list;
    }

    public List<Project> getNextWeekProjects(List<Project> projects) {
        List<Project> list = new ArrayList<>();
        for (Project p : projects) {
            if (p.getDeadline() > 4) {
                list.add(p);
            }
        }
        return list;
    }

    // Backtracking optimal schedule (NOT greedy)
    public List<Project> generateOptimalSchedule(List<Project> projects) {

        List<Project> best = new ArrayList<>();
        double[] maxRevenue = {0};

        backtrack(projects, 0, new ArrayList<>(), best, maxRevenue);
        return best;
    }

    private void backtrack(List<Project> projects, int index,
                           List<Project> current,
                           List<Project> best,
                           double[] maxRevenue) {

        if (current.size() > 5) return;
        if (!isValidSchedule(current)) return;

        double revenue = current.stream()
                .mapToDouble(Project::getRevenue)
                .sum();

        if (revenue > maxRevenue[0]) {
            maxRevenue[0] = revenue;
            best.clear();
            best.addAll(new ArrayList<>(current));
        }

        for (int i = index; i < projects.size(); i++) {
            current.add(projects.get(i));
            backtrack(projects, i + 1, current, best, maxRevenue);
            current.remove(current.size() - 1);
        }
    }

    private boolean isValidSchedule(List<Project> schedule) {

        schedule.sort(Comparator.comparingInt(Project::getDeadline));

        for (int i = 0; i < schedule.size(); i++) {
            if (i + 1 > schedule.get(i).getDeadline()) {
                return false;
            }
        }
        return true;
    }

    public double totalRevenue(List<Project> list) {
        return list.stream().mapToDouble(Project::getRevenue).sum();
    }

    public void printWeekSchedule(String title, List<Project> schedule) {

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};

        System.out.println("\n📅 " + title);

        for (int i = 0; i < days.length; i++) {
            if (i < schedule.size()) {
                System.out.println(days[i] + " → " + schedule.get(i));
            } else {
                System.out.println(days[i] + " → No Project");
            }
        }

        System.out.println("💰 Total Revenue: ₹" + totalRevenue(schedule));
    }
}
