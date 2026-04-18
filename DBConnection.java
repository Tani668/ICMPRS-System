import java.sql.*;

public class DBConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/complaintdb";
            String user = "root";
            String password = "Tanu1234#"; // change if needed

            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed!");
            System.out.println("Reason: " + e.getMessage());
            return null;
        }
    }
}
