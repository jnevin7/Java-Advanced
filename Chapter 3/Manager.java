package ex03_1_exercise;

public class Manager extends Employee2 {
    private String deptName;

    Manager(String name, int age, double salary,String deptName) {
        super(name, age, salary);
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
