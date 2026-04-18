public class Complaint {
    private int id;
    private String description;
    private int priority;
    private String priorityLevel;
    private String department;
    private String status;

    public Complaint(int id, String description) {
        this.id = id;
        this.description = description;

        this.priority = PriorityCalculator.calculate(description);
        this.priorityLevel = PriorityCalculator.getPriorityLevel(priority);
        this.department = DepartmentRouter.detectDepartment(description);

        this.status = "Open";
    }

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