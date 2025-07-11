package com.sb21java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb21java.model.Employee;
import com.sb21java.repository.EmployeeRepository;
import com.sb21java.service.EmployeeService;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired EmployeeRepository empRepository;
	@Autowired EmployeeService empService;
	
	@PostMapping("/")
	public ResponseEntity<String> addBooking(@RequestBody Employee employee)
	{
		Employee addEmp = empService.addBooking(employee);
		return new ResponseEntity<String>("Employee added Successfully!!",HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllUsers()
	{
		List<Employee> usersList =empService.getAllUsers();
		return new ResponseEntity<List<Employee>>(usersList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getUserById(@PathVariable int id)
	{
		Employee registrationBean = empService.getUserById(id);
		return new ResponseEntity<Employee>(registrationBean,HttpStatus.OK);
	} 
	
	

}
