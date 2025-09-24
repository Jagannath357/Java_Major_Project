import java.util.Scanner;
import java.util.ArrayList;


class EmployeeHandler {
    Scanner sc = new Scanner(System.in);
    ArrayList<CurrentEmployee> currentEmployees = new ArrayList<>();
    ArrayList<RetiredEmployee> retiredEmployees = new ArrayList<>();
    ArrayList<DeltaEmployee> allEmployees = new ArrayList<>();
    ArrayList<Department> departments = new ArrayList<>();

    
    void listAllEmployees(){
        if (allEmployees.isEmpty()) {
            System.out.println("\nNo Employee added Yet");
            return;
        }
        System.out.println("\nAll Employees are : ");
        for (DeltaEmployee deltaEmployee : allEmployees) {
            System.out.println(deltaEmployee.empname);
        }
    }
    
    void listCurrentEmployees() {
        if (currentEmployees.isEmpty()) {
            System.out.println("There is no Current Employees");
            return;
        }
        System.out.println("All Current Employees are : ");
        for (CurrentEmployee currentEmployee : currentEmployees) {
            System.out.println(currentEmployee.empname);
        }
    }
    
    void listRetiredEmployees() {
        if (retiredEmployees.isEmpty()) {
            System.out.println("There is no Retired Employees");
            return;
        }
        System.out.println("All Retired Employees are : ");
        for (RetiredEmployee retiredEmployee : retiredEmployees) {
            System.out.println(retiredEmployee.empname);
        }
    }
    
    void listAllDepartments() {
        if (departments.isEmpty()) {
            System.out.println("There is no Department added Yet!");
            return;
        }
        System.out.println("All Departments are : ");
        for (Department department : departments) {
            System.out.println(department.deptname);
        }
    }
    void addNewEmployee() {
        System.out.println("Enter Employee Details:");
        System.out.print("Employee ID: ");
        String empid = sc.nextLine();
        for (CurrentEmployee emp : currentEmployees) {
            if (emp.empid != null && emp.empid.equals(empid)) {
                System.out.println("Employee with this ID already exists!");
                return;
            }
        }
        System.out.print("Name: ");
        String empname = sc.nextLine();
        System.out.print("PAN No: ");
        String panno = sc.nextLine();
        System.out.print("Status (act/ret/res/ter/abs): ");
        String status = sc.nextLine();
        System.out.print("Designation (hod/manager/analyst/DE Operator): ");
        String desg = sc.nextLine();
        System.out.print("Date of Joining (yyyy-MM-dd): ");
        String doj = sc.nextLine();
        System.out.print("Date of Birth (yyyy-MM-dd): ");
        String dob = sc.nextLine();
        System.out.print("Mobile: ");
        long mobile = 0;
        try {
            mobile = Long.parseLong(sc.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid mobile number!");
            return;
        }
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Department ID: ");
        String dptid = sc.nextLine();
        System.out.print("Salary: ");
        float salary = 0;
        try {
            salary = Float.parseFloat(sc.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid salary!");
            return;
        }
        System.out.print("Health Benefit: ");
        float healthBenifete = 0;
        try {
            healthBenifete = Float.parseFloat(sc.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid health benefit!");
            return;
        }
        CurrentEmployee newEmp = new CurrentEmployee();
        newEmp.empid = empid;
        newEmp.empname = empname;
        newEmp.panno = panno;
        newEmp.status = status;
        newEmp.desg = desg;
        newEmp.doj = doj;
        newEmp.dob = dob;
        newEmp.mobile = mobile;
        newEmp.email = email;
        newEmp.dptid = dptid;
        newEmp.salary = salary;
        newEmp.healthBenifete = healthBenifete;
        currentEmployees.add(newEmp);
        allEmployees.add(newEmp);
        System.out.println("Employee added successfully!");
    }
    
    void editEmployee() {
        System.out.print("Enter Employee ID to edit: ");
        String empid = sc.nextLine();
        CurrentEmployee found = null;
        for (CurrentEmployee emp : currentEmployees) {
            if (emp.empid != null && emp.empid.equals(empid)) {
                found = emp;
                break;
            }
        }
        if (found == null) {
            System.out.println("Employee not found.");
            return;
        }
        System.out.println("Editing Employee: " + found.empname);
        System.out.print("New Name (leave blank to keep current): ");
        String empname = sc.nextLine();
        if (!empname.isEmpty()) found.empname = empname;
        System.out.print("New PAN No (leave blank to keep current): ");
        String panno = sc.nextLine();
        if (!panno.isEmpty()) found.panno = panno;
        System.out.print("New Status (leave blank to keep current): ");
        String status = sc.nextLine();
        if (!status.isEmpty()) found.status = status;
        System.out.print("New Designation (leave blank to keep current): ");
        String desg = sc.nextLine();
        if (!desg.isEmpty()) found.desg = desg;
        System.out.print("New Date of Joining (leave blank to keep current): ");
        String doj = sc.nextLine();
        if (!doj.isEmpty()) found.doj = doj;
        System.out.print("New Date of Birth (leave blank to keep current): ");
        String dob = sc.nextLine();
        if (!dob.isEmpty()) found.dob = dob;
        System.out.print("New Mobile (leave blank to keep current): ");
        String mobileStr = sc.nextLine();
        if (!mobileStr.isEmpty()) {
            try {
                found.mobile = Long.parseLong(mobileStr);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid mobile number! Keeping previous value.");
            }
        }
        System.out.print("New Email (leave blank to keep current): ");
        String email = sc.nextLine();
        if (!email.isEmpty()) found.email = email;
        System.out.print("New Department ID (leave blank to keep current): ");
        String dptid = sc.nextLine();
        if (!dptid.isEmpty()) found.dptid = dptid;
        System.out.print("New Salary (leave blank to keep current): ");
        String salaryStr = sc.nextLine();
        if (!salaryStr.isEmpty()) {
            try {
                found.salary = Float.parseFloat(salaryStr);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid salary! Keeping previous value.");
            }
        }
        System.out.print("New Health Benefit (leave blank to keep current): ");
        String healthStr = sc.nextLine();
        if (!healthStr.isEmpty()) {
            try {
                found.healthBenifete = Float.parseFloat(healthStr);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid health benefit! Keeping previous value.");
            }
        }
        System.out.println("Employee updated successfully!");
    }
    
    void terminateEmployee() {
        System.out.println("'E' for Employ and 'D' for Department");
        System.out.println("Enter your choice");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("E")) {
            System.out.println("Enter Employee Id");
            String eid = sc.nextLine();
            CurrentEmployee toRemove = null;
            for (CurrentEmployee currEmployee : currentEmployees) {
                if (currEmployee.empid != null && currEmployee.empid.equals(eid)) {
                    toRemove = currEmployee;
                    break;
                }
            }
            if (toRemove != null) {
                currentEmployees.remove(toRemove);
                allEmployees.remove(toRemove);
                System.out.println(toRemove.empid + " is successfully Terminated");
            } else {
                System.out.println("Employee doesn't exist!");
            }
        }
        else if (choice.equalsIgnoreCase("D")) {
            System.out.println("Enter Department Id");
            String did = sc.nextLine();
            Department toRemove = null;
            for (Department department : departments) {
                if (department.deptid != null && department.deptid.equals(did)) {
                    toRemove = department;
                    break;
                }
            }
            if (toRemove != null) {
                departments.remove(toRemove);
                System.out.println(toRemove.deptid + " is successfully Deleted");
            } else {
                System.out.println("Department doesn't exist!");
            }
        }
    }
    
    void displayHighestEmployees() {
        System.out.println("All Departments");
        if (currentEmployees.isEmpty()) {
            System.out.println("No current employees available.");
            return;
        }
        // Sort employees by salary descending
        ArrayList<CurrentEmployee> sorted = new ArrayList<>(currentEmployees);
        sorted.sort((a, b) -> Float.compare(b.salary, a.salary));
        int count = Math.min(3, sorted.size());
        System.out.println("\nTop " + count + " highest paid Employees are:");
        for (int i = 0; i < count; i++) {
            sorted.get(i).showEmployeeDetails();
        }
    }
    
    void displayEmployeeJoinedLastTwoYear() {
        System.out.println("Employees joined in the last two years:");
        if (currentEmployees.isEmpty()) {
            System.out.println("No current employees available.");
            return;
        }
        java.time.LocalDate now = java.time.LocalDate.now();
        int count = 0;
        for (CurrentEmployee emp : currentEmployees) {
            try {
                // Assuming doj is in format yyyy-MM-dd
                java.time.LocalDate doj = java.time.LocalDate.parse(emp.doj);
                java.time.Period period = java.time.Period.between(doj, now);
                if (period.getYears() < 2) {
                    emp.showEmployeeDetails();
                    count++;
                }
            } catch (java.time.format.DateTimeParseException ex) {
                // Skip if date is invalid or missing
            }
        }
        if (count == 0) {
            System.out.println("No employees joined in the last two years.");
        }
    }
    
    void displayEmployeesWithSameName() {
        if (currentEmployees.isEmpty()) {
            System.out.println("No current employees available.");
            return;
        }
        java.util.HashMap<String, java.util.List<CurrentEmployee>> nameMap = new java.util.HashMap<>();
        for (CurrentEmployee emp : currentEmployees) {
            nameMap.computeIfAbsent(emp.empname, k -> new java.util.ArrayList<>()).add(emp);
        }
        boolean found = false;
        for (var entry : nameMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                found = true;
                System.out.println("\nEmployees with name: " + entry.getKey());
                for (CurrentEmployee emp : entry.getValue()) {
                    emp.showEmployeeDetails();
                }
            }
        }
        if (!found) {
            System.out.println("No employees with the same name found.");
        }
    }

    void displayEmployeesInEachDepartment() {
        if (currentEmployees.isEmpty()) {
            System.out.println("No current employees available.");
            return;
        }
        java.util.HashMap<String, Integer> deptCount = new java.util.HashMap<>();
        for (CurrentEmployee emp : currentEmployees) {
            deptCount.put(emp.dptid, deptCount.getOrDefault(emp.dptid, 0) + 1);
        }
        System.out.println("\nNumber of employees in each department:");
        for (var entry : deptCount.entrySet()) {
            System.out.println("Department ID: " + entry.getKey() + " - Employees: " + entry.getValue());
        }
    }
    
    void displaySalaryOfHod() {
        System.out.print("Enter Department ID: ");
        String deptId = sc.nextLine();
        boolean found = false;
        for (CurrentEmployee emp : currentEmployees) {
            if (emp.dptid != null && emp.dptid.equals(deptId) && emp.desg != null && emp.desg.equalsIgnoreCase("hod")) {
                System.out.println("HOD Salary for Department " + deptId + ": " + emp.salary);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No HOD found for Department " + deptId);
        }
    }
    
    void displayOfficialLocationOfEmployee() {
        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();
        CurrentEmployee foundEmp = null;
        for (CurrentEmployee emp : currentEmployees) {
            if (emp.empid != null && emp.empid.equals(empId)) {
                foundEmp = emp;
                break;
            }
        }
        if (foundEmp == null) {
            System.out.println("Employee not found.");
            return;
        }
        String deptId = foundEmp.dptid;
        for (Department dept : departments) {
            if (dept.deptid != null && dept.deptid.equals(deptId)) {
                System.out.println("Official Location for Employee " + empId + ": " + dept.location);
                return;
            }
        }
        System.out.println("Department not found for employee.");
    }
    
    void displayQualificationDetailsOfEmployee() {
        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();
        boolean found = false;
        for (CurrentEmployee emp : currentEmployees) {
            if (emp.empid != null && emp.empid.equals(empId)) {
                System.out.println("Qualification details for Employee " + empId + ": [Not available in system]");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }
    }
    
    void refreshDigitalSignature() {
        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();
        boolean found = false;
        for (CurrentEmployee emp : currentEmployees) {
            if (emp.empid != null && emp.empid.equals(empId)) {
                System.out.println("Digital signature refreshed for Employee " + empId + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    void addNewDepartment() {
        System.out.println("Enter Department Details:");
        System.out.print("Department ID: ");
        String deptid = sc.nextLine();
        for (Department dept : departments) {
            if (dept.deptid != null && dept.deptid.equals(deptid)) {
                System.out.println("Department with this ID already exists!");
                return;
            }
        }
        System.out.print("Department Name: ");
        String deptname = sc.nextLine();
        System.out.print("Location: ");
        String location = sc.nextLine();
        System.out.print("Head of Department: ");
        String headOfDept = sc.nextLine();
        Department newDept = new Department();
        newDept.deptid = deptid;
        newDept.deptname = deptname;
        newDept.location = location;
        newDept.headOfDept = headOfDept;
        departments.add(newDept);
        System.out.println("Department added successfully!");
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeHandler eh = new EmployeeHandler();
        String choiceContinue;
        main_loop : while (true) {
            System.out.println("Enter 'y' to Continue or 'n' Quit");
            choiceContinue = sc.nextLine();
            if (choiceContinue == "n") {
                break;
            }
            int choice;
            do {
                System.out.println("Menu");
                System.out.println("1. List of All Employees");
                System.out.println("2. List of All current Employees");
                System.out.println("3. List of All Retired Employees");
                System.out.println("4. List of All Departments width names");
                System.out.println("5. Add a new Employee");
                System.out.println("6. Edit Existing Employee or Department");
                System.out.println("7. Terminate Employee or Delete Department");
                System.out.println("8. Display the top 3 highest paid Employees with their Salaries");
                System.out.println("9. Employees joined in the last two years");
                System.out.println("10. Search for the Employees with same name");
                System.out.println("11. Add New Department");
                System.out.println("12. List how many Employees work in each Department");
                System.out.println("13. Salary of the Department Head in a given Department");
                System.out.println("14. Official Location of the Employee");
                System.out.println("15. Display qualification details of a given employee");
                System.out.println("16. Refresh Digital Signature");
                System.out.println("17. Exit");

                System.out.println("\n Enter your choice : ");
                choice = sc.nextInt();

                if (choice<1 || choice>17) {
                    System.out.println("\nInvalid Choice\n Please Enter a valid Choice");
                    continue;
                }
            
            }while (choice<1 || choice>17);

            switch (choice) {
                case 1:
                    eh.listAllEmployees();
                    break;
                case 2:
                    eh.listCurrentEmployees();
                    break;
                case 3:
                    eh.listRetiredEmployees();
                    break;
                case 4:
                    eh.listAllDepartments();
                    break;
                case 5:
                    eh.addNewEmployee();
                    break;
                case 6:
                    eh.editEmployee();
                    break;
                case 7:
                    eh.terminateEmployee();
                    break;
                case 8:
                    eh.displayHighestEmployees();
                    break;
                case 9:
                    eh.displayEmployeeJoinedLastTwoYear();
                    break;
                case 10:
                    eh.displayEmployeesWithSameName();
                    break;
                case 11:
                    eh.addNewDepartment();
                    break;
                case 12:
                    eh.displayEmployeesInEachDepartment();
                    break;
                case 13:
                    eh.displaySalaryOfHod();
                    break;
                case 14:
                    eh.displayOfficialLocationOfEmployee();
                    break;
                case 15:
                    eh.displayQualificationDetailsOfEmployee();
                    break;
                case 16:
                    eh.refreshDigitalSignature();
                    break;
                case 17:
                    System.out.println("\nExist\n");
                    continue main_loop;

            }
        }
    }
}
