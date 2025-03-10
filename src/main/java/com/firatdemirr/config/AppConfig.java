package com.firatdemirr.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.firatdemirr.model.Employee;

@Configuration
public class AppConfig {
	@Bean
	public List<Employee> employeeList() {

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1", "Fırat", "Demir"));
		employeeList.add(new Employee("2", "Enes", "Bayram"));
		employeeList.add(new Employee("3", "Yakup", "Reçber"));
		employeeList.add(new Employee("4", "Bilal", "Çamur"));
		return employeeList;

	}

}
