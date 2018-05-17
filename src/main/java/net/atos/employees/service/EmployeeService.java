package net.atos.employees.service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.Getter;
import net.atos.employees.domain.Employee;

@Service
@Getter
public class EmployeeService {
	
	/**
	 * metodo utilizado para carregar as skills dos colaboradores
	 * e retorna-las de forma distinta atraves de um SET
	 * @param     lista de colaboradores
	 * @return    todos os skills da base sem repeticao
	 */
	public Set<String> loadSkills(List<Employee> employeeList) {
		Set<String> allSkills = new TreeSet<>();
		employeeList.forEach(emp -> {
			allSkills.addAll(emp.getSkills());
		});
		return allSkills;
	}
	
	/**
	 * metodo utilizado para listar os colaboradores pelas suas skills
	 * @param lista de colaboradores
	 * @param set de skills
	 */
	public List<Employee> findEmployeeBySkill(List<Employee> employeeList, Set<String> skills) {
		return  employeeList.stream()
				.filter(p -> p.getSkills().containsAll(skills))
				.collect(Collectors.toList()); 	
	}
	
}
