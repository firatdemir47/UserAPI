package com.firatdemirr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.firatdemirr.model.Employee;
import com.firatdemirr.model.UpdateEmployeeRequest;
import com.firatdemirr.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployeeList() {
		return employeeRepository.getAllEmployeList();
	}

	public Employee getEmployeeByıd(String id) {
		return employeeRepository.getEmplloyeeByıd(id);
	}

	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		return employeeRepository.getEmployeWithParams(firstName, lastName);
	}

	public Employee saveEmployee(Employee newEmployee) {
		return employeeRepository.saveEmployee(newEmployee);
	}

	public boolean deleteEmployee(String id) {
		return employeeRepository.deleteEmployee(id);
	}
	public Employee updateEmployee(String id,UpdateEmployeeRequest request) {
		return employeeRepository.updateEmployee(id, request);
	}
}
