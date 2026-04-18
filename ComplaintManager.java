import java.sql.*;

public class ComplaintManager {

    // ADD
    public void addComplaint(Complaint c) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            if (con == null) return;

            String query = "INSERT INTO complaints (id, description, priority, status, high_priority_flag, created_at) VALUES (?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getDescription());
            ps.setInt(3, c.getPriority());
            ps.setString(4, c.getStatus());
            ps.setInt(5, c.getPriority() >= 7 ? 1 : 0);
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

            ps.executeUpdate();

            System.out.println("✅ Complaint Added!");
            System.out.println("Priority: " + c.getPriorityLevel());
            System.out.println("Department: " + c.getDepartment());

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("⚠ ID already exists!");

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());

        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("⚠ Error closing DB");
            }
        }
    }

    // VIEW
    public void viewComplaints() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            if (con == null) return;

            String query = "SELECT * FROM complaints ORDER BY priority DESC";
            st = con.createStatement();
            rs = st.executeQuery(query);

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("\n----------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Priority: " + rs.getInt("priority"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Time: " + rs.getTimestamp("created_at"));
            }

            if (!found)
                System.out.println("⚠ No complaints found");

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {}
        }
    }

    // SEARCH
    public void searchComplaint(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            if (con == null) return;

            String query = "SELECT * FROM complaints WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Found:");
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Priority: " + rs.getInt("priority"));
                System.out.println("Status: " + rs.getString("status"));
            } else {
                System.out.println("❌ Not found");
            }

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {}
        }
    }

    // UPDATE
    public void updateStatus(int id, String status) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            if (con == null) return;

            String query = "UPDATE complaints SET status=? WHERE id=?";
            ps = con.prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Updated");
            else
                System.out.println("❌ Not found");

        } catch (SQLException e) {
            System.out.println("❌ DB Error");

        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {}
        }
    }

    // DELETE
    public void deleteComplaint(int id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            if (con == null) return;

            String query = "DELETE FROM complaints WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("🗑 Deleted");
            else
                System.out.println("❌ Not found");

        } catch (SQLException e) {
            System.out.println("❌ DB Error");

        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {}
        }
    }
}
