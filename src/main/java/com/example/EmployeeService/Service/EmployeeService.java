package com.example.EmployeeService.Service;

import com.example.EmployeeService.Model.EmployeeDO;
import com.example.EmployeeService.Payload.Employee;
import com.example.EmployeeService.Repository.EmployeeRepository;
import com.example.EmployeeService.Repository.ExternalEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class EmployeeService {

    private ExternalEmployeeRepository externalEmployeeRepository;
    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,ExternalEmployeeRepository externalEmployeeRepository,ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.externalEmployeeRepository = externalEmployeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<Employee>  getEmployees(){
        List<Employee> employees = externalEmployeeRepository.getEmployeesFromApi();
        //one way of doing modalMapping
        this.modelMapper.typeMap(Employee.class,EmployeeDO.class).addMappings(mapper->{
            mapper.map(src-> src.getEmployee_name(),EmployeeDO::setName);
            mapper.map(src-> src.getEmployee_age(), EmployeeDO::setAge);
        });
        List<EmployeeDO> employeesDO = modelMapper.map(employees, new TypeToken<List<EmployeeDO>>(){}.getType());
        //
        List<EmployeeDO> employeesDO1 =employees.stream().map(emp-> modelMapper.map(emp,EmployeeDO.class)).collect(Collectors.toList());
        List<EmployeeDO> employeesDO2 =employees.stream().map(emp-> new EmployeeDO(emp)).collect(Collectors.toList());
        employeeRepository.saveAll(employeesDO);
        return employees;
    }

    public Employee getEmployee(Integer id){
       Optional<EmployeeDO> employee = employeeRepository.findById(id);
       return !employee.isEmpty()? new Employee(employee.get()): null;
    }

    public Employee updateEmployee(Integer id, String name, Employee employee){
        EmployeeDO employeeDO = new EmployeeDO(employee);
        employeeRepository.save(employeeDO);
        return this.getEmployee(id);
    }



}
