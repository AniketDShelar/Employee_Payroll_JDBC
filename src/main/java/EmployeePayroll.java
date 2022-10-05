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
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "SELECT * FROM employee_payroll");
//            if(b){
//               resultSet = statement.getResultSet();
//
//            }
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name").trim();
                String salary = resultSet.getString("salary").trim();
                String gender = resultSet.getString("Gender").trim();
                String department = resultSet.getString("Department").trim();
                System.out.println(name +" "+ salary +" "+ gender +" "+ department);
                }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    } // function ends
}
