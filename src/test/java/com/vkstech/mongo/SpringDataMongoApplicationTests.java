package com.vkstech.mongo;

import com.vkstech.mongo.model.Employee;
import com.vkstech.mongo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringDataMongoApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	void printEmployees(List<Employee> employeesList){
		employeesList.forEach(System.out::println);
	}

	// Find list of employees with salary greater than 40000
	@Test
	void employeeGreaterThan(){
		List<Employee> employees = employeeRepository.findEmployeesGreaterThan(40000.0);
		printEmployees(employees);
	}

	// Find list of employees with salary less than 80000
	@Test
	void employeeLessThan(){
		List<Employee> employees = employeeRepository.findEmployeesLessThan(80000.0);
		printEmployees(employees);
	}

	// Find list of employees with salary between 40000 and 80000
	@Test
	void employeeBetween(){
		List<Employee> employees = employeeRepository.findEmployeesBetween(40000.0, 80000.0);
		printEmployees(employees);
	}

}
