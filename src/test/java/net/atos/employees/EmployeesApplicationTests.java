package net.atos.employees;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.atos.employees.domain.Employee;
import net.atos.employees.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesApplicationTests {

    private List<Employee> employees = new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void initObjects() {
        employees = employeeRepository.getEmployees();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void verifiyIfExistsSkills() {
        Integer size = 0;
        for (Employee emp : employees) {
            size += emp.getSkills().size();
        }
        assertTrue(size > 0);
    }

    @Test
    public void verifiyIfTheDataIsLoaded() {
        List<Employee> employees = employeeRepository.getEmployees();
        assertTrue(employees.size() > 0);
    }
}
