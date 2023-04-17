package com.example.homework.service;

import com.example.homework.exception.EmployeeAlreadyAddedException;
import com.example.homework.exception.EmployeeNotFoundException;
import com.example.homework.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }
    @Override
    public Employee add(String firstName, String lastName, int salary, int departament) {
        Employee employee = new Employee(firstName, lastName, salary, departament);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int departament) {
        Employee employee = new Employee(firstName, lastName, salary, departament);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int departament) {
        Employee employee = new Employee(firstName, lastName, salary, departament);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>(employees.values());
        return employeeList;
//        List<Employee> employeeList = new ArrayList<>(employees.values());
//        return employeeList;
    }


}
