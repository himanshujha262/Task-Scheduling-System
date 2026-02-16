import java.sql.*;
import java.util.*;

public class ProjectDAO {

    static String url = "jdbc:postgresql://localhost:5432/promange_db";
    static String user = "postgres";
    static String password = "Madhubani@16";

    public static List<Project> getAllProjects() {

        List<Project> list = new ArrayList<>();

        String sql = "SELECT * FROM projects";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Project(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("deadline"),
                        rs.getInt("revenue")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void Project(String title, int deadline, int revenue) {

    }
}
