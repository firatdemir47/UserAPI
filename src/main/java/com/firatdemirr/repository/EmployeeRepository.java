package com.firatdemirr.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.firatdemirr.model.Employee;
import com.firatdemirr.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {
	@Autowired
	private List<Employee> employeeList;

	public List<Employee> getAllEmployeList() {
		return employeeList;
	}

	public Employee getEmplloyeeByıd(String id) {
		Employee findEmployee = null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				findEmployee = employee;
				break;

			}
		}
		return findEmployee;
	}

	public List<Employee> getEmployeWithParams(String firstName, String lastName) {
		List<Employee> employeWithParams = new ArrayList<>();
		if (firstName == null && lastName == null) {
			return employeeList;
		}
		for (Employee employee : employeeList) {
			if (firstName != null && lastName != null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)
						&& employee.getLastName().equalsIgnoreCase(lastName)) {
					employeWithParams.add(employee);
				}
			}
			if (firstName != null && lastName == null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeWithParams.add(employee);
				}

			}
			if (lastName != null && firstName == null) {
				if (employee.getLastName().equalsIgnoreCase(lastName)) {
					employeWithParams.add(employee);
				}
			}
		}
		return employeWithParams;
	}

	public Employee saveEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;

	}

	public boolean deleteEmployee(String id) {
		Employee deleteEmployee = null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				deleteEmployee = employee;
				break;
			}
		}
		if (deleteEmployee == null) {
			return false;
		}
		employeeList.remove(deleteEmployee);
		return true;
	}

	private Employee findEmployeeById(String id) {
		Employee findEmployee = null;
		for (Employee employee : employeeList) {

			if (employee.getId().equals(id)) {
				findEmployee = employee;
				break;
			}

		}
		return findEmployee;
	}
	public Employee updateEmployee(String id,UpdateEmployeeRequest request) {
		Employee findEmployee =findEmployeeById(id);
		if (findEmployee!=null) {
			deleteEmployee(id);
			Employee updateEmployee = new Employee();
			updateEmployee.setId(id);
			updateEmployee.setFirstName(request.getFirstName());
			updateEmployee.setLastName(request.getLastName());
			employeeList.add(updateEmployee);
			return updateEmployee;
		}
		return null;
	}

}
