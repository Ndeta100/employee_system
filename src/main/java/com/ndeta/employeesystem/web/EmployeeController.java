package com.ndeta.employeesystem.web;

import com.ndeta.employeesystem.entity.Employee;
import com.ndeta.employeesystem.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class EmployeeController {
    EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return  employeeService.createEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return  employeeService.getAllEmployees();
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted=false;
        deleted=employeeService.deleteEmployee(id);
        Map<String, Boolean>response=new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable Long id){
        Employee employee=null;
        employee=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody Employee  employee){
        employee=employeeService.updateEmployee(id,employee);
        return ResponseEntity.ok(employee);
    }
}
