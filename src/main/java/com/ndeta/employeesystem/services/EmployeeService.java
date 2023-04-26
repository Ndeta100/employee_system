package com.ndeta.employeesystem.services;

import com.ndeta.employeesystem.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Boolean deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);

}
