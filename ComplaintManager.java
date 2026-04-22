import java.sql.*;

public class ComplaintManager {

    // ---------------- ADD COMPLAINT ----------------
    public void addComplaint(Complaint c) {

        String query = "INSERT INTO complaints (id, description, priority, status, high_priority_flag, created_at) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            if (con == null) {
                System.out.println("⚠ Database not connected!");
                return;
            }

            ps.setInt(1, c.getId());
            ps.setString(2, c.getDescription());
            ps.setInt(3, c.getPriority());
            ps.setString(4, c.getStatus());
            ps.setInt(5, c.getPriority() >= 7 ? 1 : 0);
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

            ps.executeUpdate();

            System.out.println("✅ Complaint Added Successfully!");
            System.out.println("➡ Priority: " + c.getPriority() + " (" + c.getPriorityLevel() + ")");
            System.out.println("➡ Routed to: " + c.getDepartment());

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("⚠ Complaint ID already exists!");
        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }

    // ---------------- VIEW ALL ----------------
    public void viewComplaints() {

        String query = "SELECT * FROM complaints ORDER BY priority DESC";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (con == null) {
                System.out.println("⚠ Database not connected!");
                return;
            }

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("\n------------------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Priority: " + rs.getInt("priority"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("High Priority Flag: " + rs.getInt("high_priority_flag"));
                System.out.println("Time: " + rs.getTimestamp("created_at"));
            }

            if (!found) {
                System.out.println("⚠ No complaints found.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }

    // ---------------- SEARCH ----------------
    public void searchComplaint(int id) {

        String query = "SELECT * FROM complaints WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            if (con == null) {
                System.out.println("⚠ Database not connected!");
                return;
            }

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n🔍 Complaint Found:");
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Priority: " + rs.getInt("priority"));
                System.out.println("Status: " + rs.getString("status"));
            } else {
                System.out.println("❌ Complaint not found!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }

    // ---------------- UPDATE ----------------
    public void updateStatus(int id, String status) {

        String query = "UPDATE complaints SET status=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            if (con == null) {
                System.out.println("⚠ Database not connected!");
                return;
            }

            ps.setString(1, status);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Status Updated Successfully!");
            else
                System.out.println("❌ Complaint not found!");

        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }

    // ---------------- DELETE ----------------
    public void deleteComplaint(int id) {

        String query = "DELETE FROM complaints WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            if (con == null) {
                System.out.println("⚠ Database not connected!");
                return;
            }

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("🗑 Complaint Deleted Successfully!");
            else
                System.out.println("❌ Complaint not found!");

        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }
}
