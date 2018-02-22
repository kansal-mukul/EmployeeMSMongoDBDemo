package com.hcl.microservice.employee;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		System.out.println("Get all Employees...");
 
		return employeeRepository.findAll();
	}
	
	@RequestMapping(value = "/employee/create", method = RequestMethod.POST)
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		System.out.println("Create employee: " + employee.getFirstName() + "...");
 
		//employee.setActive(false);
		return employeeRepository.save(employee);
	}
 
	 @RequestMapping(value = "/employee/update/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Employee> updateemployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		System.out.println("Update employee with ID = " + id + "...");
 
		Employee employeeData = employeeRepository.findOne(id);
		if (employee == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		employeeData.setFirstName(employee.getFirstName());
		employeeData.setLastName(employee.getLastName());
		Employee updatedemployee = employeeRepository.save(employeeData);
		return new ResponseEntity<>(updatedemployee, HttpStatus.OK);
	}
 
	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteemployee(@PathVariable("id") Long id) {
		System.out.println("Delete employee with ID = " + id + "...");
 
		employeeRepository.delete(id);
		
		return new ResponseEntity<>("employee has been deleted!", HttpStatus.OK);
	}
	
	  @RequestMapping(value = "/employee/deleteall", method = RequestMethod.DELETE)
	    public ResponseEntity<Employee> deleteAllUsers() {
	       
	        employeeRepository.deleteAll();
	        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	    }
	
	

}
