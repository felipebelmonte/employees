package net.atos.employees;

import net.atos.employees.repository.EmployeeRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}
	
    @Bean
    public EmployeeRepository employeeRepository() {
        return new EmployeeRepository();
    }
    
}
