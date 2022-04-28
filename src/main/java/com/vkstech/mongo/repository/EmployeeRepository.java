package com.vkstech.mongo.repository;

import com.vkstech.mongo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    List<Employee> findByName(String name);

    @Query(" { name :  ?0 }")
    List<Employee> findByNameByQuery(String name);

    @Query(" { name :  { $eq : ?0 } }")
    List<Employee> findByNameByQueryOperator(String name);

    // Find list of employees with salary greater than passed value
    @Query("{ salary : { $gt :  ?0 } }")
    List<Employee> findEmployeesGreaterThan(Double salary);

    // Find list of employees with salary less than passed value
    @Query("{ salary : { $lt :  ?0 } }")
    List<Employee> findEmployeesLessThan(Double salary);

    // Find list of employees with salary between value1 and value2
    @Query("{ $and: [ {salary : { $gt :  ?0 }}, { salary : { $lt :  ?1 } } ]}")
    List<Employee> findEmployeesBetween(Double salary1, Double salary2);
}
