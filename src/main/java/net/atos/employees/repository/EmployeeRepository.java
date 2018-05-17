package net.atos.employees.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.atos.employees.domain.Employee;
import net.atos.employees.exception.RepositoryException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class EmployeeRepository {
	
	private List<Employee> employees;
	/**
	 * metodo para criar um repositorio de colaboradores
	 * atraves de um arquivo fisico JSON existente no disco
	 * @return    lista de colaboradores existentes no JSON
	 */
	public List<Employee> loadData() throws RepositoryException{
		ObjectMapper mapper = new ObjectMapper();
		JavaTimeModule javaTimeModule = new JavaTimeModule();
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(javaTimeModule);
		try {
			File file = new File("C:\\Users\\Felipe\\workspace\\employees\\src\\main\\resources\\json\\employees.json");
			List<Employee> employees = mapper.readValue(file,
					new TypeReference<List<Employee>>(){});
			return employees;
		} catch (Exception e) {
			throw new RepositoryException("Error at Deserialize",e.getCause());
		}
	}
	
	public List<Employee> getEmployees() {
		if (this.employees == null) {
			try {
				this.employees = loadData();
			} catch (RepositoryException e) {
			  System.out.println("Error loading data!");
			}
		}
		return this.employees;
		
	}
}
