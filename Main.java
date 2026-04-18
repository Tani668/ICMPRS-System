import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ComplaintManager cm = new ComplaintManager();

        while (true) {
            try {
                System.out.println("\n==== Complaint System ====");
                System.out.println("1. Add");
                System.out.println("2. View");
                System.out.println("3. Search");
                System.out.println("4. Update");
                System.out.println("5. Delete");
                System.out.println("6. Exit");

                System.out.print("Choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("⚠ Invalid input");
                    sc.nextLine();
                    continue;
                }

                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {

                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Description: ");
                        String desc = sc.nextLine();

                        if (desc.isEmpty()) {
                            System.out.println("⚠ Empty description");
                            break;
                        }

                        cm.addComplaint(new Complaint(id, desc));
                        break;

                    case 2:
                        cm.viewComplaints();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        cm.searchComplaint(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Status: ");
                        String status = sc.nextLine();

                        cm.updateStatus(uid, status);
                        break;

                    case 5:
                        System.out.print("ID: ");
                        cm.deleteComplaint(sc.nextInt());
                        break;

                    case 6:
                        System.out.println("Bye!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}
