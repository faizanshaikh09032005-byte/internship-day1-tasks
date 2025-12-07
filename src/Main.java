import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // Connection details
            String url = "jdbc:postgresql://localhost:5432/internship_day1";
            String user = "postgres";
            String password = "Admin@12345";  // your real password

            // Connect
            con = DriverManager.getConnection(url, user, password);

            System.out.println("Connected successfully!");

            // (Optional) Create a statement just to show closing
            stmt = con.createStatement();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();

                System.out.println("All connections closed successfully.");
            } catch (Exception e) {
                System.out.println("Close error: " + e.getMessage());
            }
        }
    }
}
