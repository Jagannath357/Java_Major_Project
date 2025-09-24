//DeltaEmployee

interface Employee {
    void getEmployeeStatus();
}

class DeltaEmployee implements Employee {
    String empid, empname;
    String panno;
    String status; // ret, act, res, ter, abs
    String desg; // hod, manager, analyst, DE Operator
    String doj, dob;
    long mobile;
    String email;
    String dptid;

    public void getEmployeeStatus() {
        System.out.println(status);
    }
    // Removed per-instance employee list
}

class RetiredEmployee extends DeltaEmployee {
    float pension, healthBenifete;
    // Removed per-instance retired employee list

    void showEmployeeDetails() {
        System.out.println("\nDetails of " + this.empname + " Employee");
        System.out.println(this.empname);
        System.out.println(this.empid);
        System.out.println(this.email);
        System.out.println(this.desg);
        System.out.println(this.dob);
        System.out.println(this.doj);
        System.out.println(this.status);
        System.out.println(this.dptid);
        System.out.println(this.mobile);
        System.out.println(this.panno);
        System.out.println(this.pension);
        System.out.println(this.healthBenifete);
    }
}

class CurrentEmployee extends DeltaEmployee {
    float salary, healthBenifete;
    // Removed per-instance current employee list

    void showEmployeeDetails() {
        System.out.println("\nDetails of " + this.empname + " Employee");
        System.out.println(this.empname);
        System.out.println(this.empid);
        System.out.println(this.email);
        System.out.println(this.desg);
        System.out.println(this.dob);
        System.out.println(this.doj);
        System.out.println(this.status);
        System.out.println(this.dptid);
        System.out.println(this.mobile);
        System.out.println(this.panno);
        System.out.println(this.salary);
        System.out.println(this.healthBenifete);

    }
}