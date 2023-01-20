package com.example.EmployeeService.Controller;

import com.example.EmployeeService.Model.EmployeeDO;
import com.example.EmployeeService.Payload.Employee;
import com.example.EmployeeService.Repository.EmployeeRepository;
import com.example.EmployeeService.Repository.ExternalEmployeeRepository;
import com.example.EmployeeService.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
       this.employeeService = employeeService;
    }

    @GetMapping("/getEmployees")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> getEmployees(){
             List<Employee>  employees = this.employeeService.getEmployees();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(employees);
    }

    @GetMapping("/getEmployee/{id}/details")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> getEmployees(@PathVariable("id") Integer id){
        Employee employee = this.employeeService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employee);
    }

    @PutMapping(value = "/getEmployee/{id}/update",params = {"name"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> updateEmployees(@PathVariable("id")Integer id ,@RequestParam("name") String name, @RequestBody Employee employee){
        this.employeeService.updateEmployee(id,name, employee);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employee);
    }

//    @GetMapping("/getEmployees")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<Employee>> getPostAndEmployees(){
//        List<Employee>  employees = this.employeeService.getEmployees();
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employees);
//    }

}

//put with request param
//post
//Completable future
