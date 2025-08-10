package com.sb21java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb21java.model.Employee;
import com.sb21java.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	public Employee addBooking(Employee employee) {
		return empRepository.save(employee);
	}

	public List<Employee> getAllUsers() {
		return empRepository.findAll();
	}

	public Employee getUserById(int id) {
		return empRepository.findById(id).orElse(null);
	}
	
	
}
