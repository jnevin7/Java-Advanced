package ex02_1_exercise;

public class Employee {
    public String name, surname;
    public int age;

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.name = "James";
        emp1.surname = "Nevin";
        emp1.age = 33;
        System.out.println("Employee Name:\n" + emp1.name + " " + emp1.surname);
        System.out.println();
        System.out.println("Employee Age:\n" + emp1.age);

    }
}
