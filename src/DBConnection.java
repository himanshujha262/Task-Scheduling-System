import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/promange_db";
        String user = "postgres";
        String password = "Madhubani@16";  // put your actual password

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to PostgreSQL Successfully!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
        }
    }
}
