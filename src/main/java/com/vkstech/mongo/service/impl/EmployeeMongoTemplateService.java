package com.vkstech.mongo.service.impl;

import com.vkstech.mongo.dto.EmployeeDto;
import com.vkstech.mongo.model.Employee;
import com.vkstech.mongo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeMongoTemplateService implements EmployeeService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public EmployeeMongoTemplateService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        return mongoTemplate.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return mongoTemplate.findById(id, Employee.class);
    }

    @Override
    public List<Employee> getEmployeeListByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        return mongoTemplate.find(query, Employee.class);
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto) {
        Employee employee = getEmployeeById(employeeDto.getId());
        BeanUtils.copyProperties(employeeDto, employee, "id");
        return mongoTemplate.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = getEmployeeById(id);
        mongoTemplate.remove(employee);
    }
}
