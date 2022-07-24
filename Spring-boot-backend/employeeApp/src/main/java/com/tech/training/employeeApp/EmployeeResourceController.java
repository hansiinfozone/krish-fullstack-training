package com.tech.training.employeeApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeResourceController {

	@Autowired
	private final EmployeeService employeeService;

	public EmployeeResourceController(EmployeeService empService) {
		this.employeeService = empService;

	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {

		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/addemployee")
	public ResponseEntity<Employee> addEmployeeOne(@RequestBody Employee employee) {
		Employee newEmploee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmploee, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployeeOne(@RequestBody Employee employee) {
		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployeeOne(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
