package ex18_1_exercise;

import java.sql.*;
import java.util.Date;

public class SimpleJDBCExample {

    public static void main(String[] args) {
        // Create the "url"
        // assume database server is running on the localhost
        String url = "jdbc:postgresql://localhost:5432/analysis";
        String username = "postgres";
        String password = "Wastelands2024!";
        String query = "SELECT * FROM employee_jdbc";


        // A try-with-resources example
        // Connection and Statement implement java.lan.AutoCloseable
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int empID = rs.getInt("id");
                String first = rs.getString("firstname");
                String last = rs.getString("lastname");
                Date birth_date = rs.getDate("birthdate");
                float salary = rs.getFloat("salary");

                System.out.println("Employee ID:   " + empID + "\n"
                        + "Employee Name: " + first.trim() + " " + last.trim() + "\n"
                        + "Birth Date:    " + birth_date + "\n"
                        + "Salary:        " + salary + "\n");

            }
        } catch (SQLException e) {
            System.out.println("Exception creating connection: " + e);
            System.exit(0);
        }
        // No need to close the Connection and Statement objects, the compiler
        // will generate these for us and call the close() statement on this
        // objects in the order we obtained them in the try
    }
}