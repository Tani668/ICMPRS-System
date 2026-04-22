public class Complaint extends BaseComplaint {

    private int priority;
    private String priorityLevel;
    private String department;
    private String status;

    public Complaint(int id, String description) {
        super(id, description); // inheritance

        this.priority = PriorityCalculator.calculate(description);
        this.priorityLevel = PriorityCalculator.getPriorityLevel(priority);
        this.department = DepartmentRouter.detectDepartment(description);

        this.status = "Open";
    }

    // METHOD OVERRIDING (Polymorphism)
    @Override
    public void displayBasicInfo() {
        super.displayBasicInfo();
        System.out.println("Priority: " + priority);
        System.out.println("Level: " + priorityLevel);
        System.out.println("Department: " + department);
        System.out.println("Status: " + status);
    }

    // Getters
    public int getId() { return id; }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
    public String getPriorityLevel() { return priorityLevel; }
    public String getDepartment() { return department; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}
