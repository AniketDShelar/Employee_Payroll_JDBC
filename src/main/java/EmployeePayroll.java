import java.sql.*;

public class EmployeePayroll {
    public static void main(String arg[])
    {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Employee_payroll_service_database",
                    "root", "Aniket@175");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database
            Statement statement;
            statement = connection.createStatement();
            boolean result;
            result = statement.execute("update employee_payroll set salary = 40000 where id = 1");
            int id;
            String name;
            String salary;
            String gender;
            String department;
            ResultSet rs = null;
            if(result) {
                rs = statement.getResultSet();

//                while (rs.next()) {
//                    id = rs.getInt("ID");
//                    name = rs.getString("Name").trim();
//                    salary = rs.getString("salary").trim();
//                    gender = rs.getString("Gender").trim();
//                    department = rs.getString("Department").trim();
//                    System.out.println(name + " " + salary + " " + gender + " " + department);
//                }
            }else{
                int count = statement.getUpdateCount();
                System.out.println(count);
            }
//            rs.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    } // function ends
}
