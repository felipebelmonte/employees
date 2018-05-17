package net.atos.employees.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.atos.employees.domain.Employee;
import net.atos.employees.repository.EmployeeRepository;
import net.atos.employees.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("employeelist")
    public String employeeList(Model model) {
		List<Employee> employeeList = employeeRepository.getEmployees();
		Iterable<String> skills = employeeService.loadSkills(employeeList);
		Iterable<Employee> employees = employeeList;
		model.addAttribute("employees",employees);
		model.addAttribute("skills", skills);
    	return "employeelist";
    }
	
	@RequestMapping(value= "search", method = RequestMethod.POST)
	public String search(@RequestParam("idSkill") List<String> skillsList, 
			Model model) {
		List<Employee> employeeList = employeeRepository.getEmployees();	
		Iterable<String> skills = employeeService.loadSkills(employeeList);
		if (skillsList != null) {
			Set<String> selectedSkill = new HashSet<String>(skillsList);
			Iterable<Employee> employees = employeeService.findEmployeeBySkill(employeeList, selectedSkill);
			model.addAttribute("employees",employees);
			model.addAttribute("skills", skills);
		}		
		return "employeelist";
	}
	
}
