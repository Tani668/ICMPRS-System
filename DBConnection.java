import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/complaintdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Tanu1234#"; // change if needed

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed!");
            System.out.println("Reason: " + e.getMessage());
            return null;
        }
    }
}
