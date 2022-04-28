package com.vkstech.mongo.service;

import com.vkstech.mongo.dto.EmployeeDto;
import com.vkstech.mongo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(EmployeeDto employeeDto);

    Employee getEmployeeById(Long id);

    List<Employee> getEmployeeListByName(String name);

    Employee updateEmployee(EmployeeDto employeeDto);

    void deleteEmployeeById(Long id);
}
