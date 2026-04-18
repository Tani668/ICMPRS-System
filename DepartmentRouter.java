public class DepartmentRouter {

    public static String detectDepartment(String desc) {
        desc = desc.toLowerCase();

        if (desc.contains("payment") || desc.contains("refund") || desc.contains("billing"))
            return "Finance";

        if (desc.contains("login") || desc.contains("password") || desc.contains("account"))
            return "IT Support";

        if (desc.contains("delivery") || desc.contains("order") || desc.contains("package"))
            return "Logistics";

        if (desc.contains("product") || desc.contains("quality") || desc.contains("damaged"))
            return "Product Team";

        return "General Support";
    }
}