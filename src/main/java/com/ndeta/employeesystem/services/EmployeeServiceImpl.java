package com.ndeta.employeesystem.services;

import com.ndeta.employeesystem.entity.Employee;
import com.ndeta.employeesystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee employee1=employeeRepository.findById(id).get();
        employee1.setEmailId(employee.getEmailId());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employeeRepository.save(employee1);
        return employee;
    }
}
