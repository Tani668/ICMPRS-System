import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ComplaintManager cm = new ComplaintManager();

        while (true) {
            try {
                System.out.println("\n==== ICMPRS System ====");
                System.out.println("1. Add Complaint");
                System.out.println("2. View All");
                System.out.println("3. Search by ID");
                System.out.println("4. Update Status");
                System.out.println("5. Delete Complaint");
                System.out.println("6. Exit");

                System.out.print("Enter choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("⚠ Invalid input! Enter a number.");
                    sc.nextLine();
                    continue;
                }

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("ID: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("⚠ Invalid ID!");
                            sc.nextLine();
                            break;
                        }
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Description: ");
                        String desc = sc.nextLine();

                        if (desc.trim().isEmpty()) {
                            System.out.println("⚠ Description cannot be empty!");
                            break;
                        }

                        cm.addComplaint(new Complaint(id, desc));
                        break;

                    case 2:
                        cm.viewComplaints();
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("⚠ Invalid ID!");
                            sc.nextLine();
                            break;
                        }
                        cm.searchComplaint(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("ID: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("⚠ Invalid ID!");
                            sc.nextLine();
                            break;
                        }
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New Status: ");
                        String status = sc.nextLine();

                        if (status.trim().isEmpty()) {
                            System.out.println("⚠ Status cannot be empty!");
                            break;
                        }

                        cm.updateStatus(uid, status);
                        break;

                    case 5:
                        System.out.print("ID: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("⚠ Invalid ID!");
                            sc.nextLine();
                            break;
                        }
                        cm.deleteComplaint(sc.nextInt());
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("⚠ Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("❌ Unexpected Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}
