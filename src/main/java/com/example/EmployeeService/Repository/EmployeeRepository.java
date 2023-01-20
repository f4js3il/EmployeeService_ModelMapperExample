package com.example.EmployeeService.Repository;


import com.example.EmployeeService.Model.EmployeeDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDO,Integer> {
}
