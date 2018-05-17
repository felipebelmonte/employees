package net.atos.employees.repository;

import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.java.Log;
import net.atos.employees.domain.Employee;
import net.atos.employees.exception.RepositoryException;

@Log
@Component
public class EmployeeRepository {

    private List<Employee> employees;

    /**
     * metodo para criar um repositorio de colaboradores atraves de um arquivo
     * fisico JSON existente no disco
     * 
     * @return lista de colaboradores existentes no JSON
     */
    public List<Employee> loadData() throws RepositoryException {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(javaTimeModule);
        try {
            Resource resource = new ClassPathResource("/json/employees.json");
            InputStream resourceInputStream = resource.getInputStream();
            List<Employee> employees = mapper.readValue(resourceInputStream, new TypeReference<List<Employee>>() {
            });
            return employees;
        } catch (Exception e) {
            throw new RepositoryException("Error at Deserialize", e);
        }
    }

    public List<Employee> getEmployees() {
        if (this.employees == null) {
            try {
                this.employees = loadData();
            } catch (RepositoryException e) {
                log.log(Level.SEVERE, "Error on Loading Data", e);
            }
        }
        return this.employees;
    }
}
