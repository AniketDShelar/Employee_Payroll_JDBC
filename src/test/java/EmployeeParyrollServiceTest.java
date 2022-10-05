import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeParyrollServiceTest {
    @Test
    void givenThreeEmployeesAfterInFileWritingShouldReturnEntryCount(){
        Employee employee1 = new Employee(1,"Amit",20000);
        Employee employee2 = new Employee(2,"Neha",25000);
        Employee employee3 = new Employee(3,"akash",30000);

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        EmployeeParyrollService employeeParyrollService = new EmployeeParyrollService(list);
        employeeParyrollService.writeData(EmployeeParyrollService.IOService.FILE_IO);
        employeeParyrollService.readData(EmployeeParyrollService.IOService.FILE_IO);
        long count = employeeParyrollService.countEntries(EmployeeParyrollService.IOService.FILE_IO);
        Assertions.assertEquals(3,count);
    }
}
