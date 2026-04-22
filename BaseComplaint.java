public class BaseComplaint {
    protected int id;
    protected String description;

    public BaseComplaint(int id, String description) {
        this.id = id;
        this.description = description;
    }

    // Method to be overridden (Polymorphism)
    public void displayBasicInfo() {
        System.out.println("ID: " + id);
        System.out.println("Description: " + description);
    }
}
