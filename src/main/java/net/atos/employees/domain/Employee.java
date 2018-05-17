package net.atos.employees.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
public class Employee {

	@JsonProperty("name")
	private String name;
	@JsonProperty("role")
	private String role;
	@JsonProperty("salary")
	private String salary;
	@JsonProperty("manager")
	private String manager;
	@JsonProperty("gcm")
	private String gcm;
	@JsonProperty("projects")
	private List<Projects> projects = new ArrayList<>();
	@JsonProperty("skills")
	private List<String> skills =  new ArrayList<>();
	@JsonProperty("certification")
	private List<String> certification = new ArrayList<>();
	
	public Employee() {}
}
