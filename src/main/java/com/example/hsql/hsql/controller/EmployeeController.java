package com.example.hsql.hsql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hsql.hsql.model.EmployeeModel;
import com.example.hsql.hsql.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EmployeeModel> getEmployees() {
        return (List<EmployeeModel>) repository.findAll();
    }

    @PostMapping
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employee) {
        return repository.save(employee);
    }

    @GetMapping("/{id}")
    public Optional<EmployeeModel> getEmployeeById(@RequestBody EmployeeModel employee, @PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public EmployeeModel updateEmployee(@RequestBody EmployeeModel employee, @PathVariable Long id) {
        EmployeeModel employeeToUpdate = repository.findById(id).get();
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setEmail(employee.getEmail());
        return repository.save(employeeToUpdate);
    }

    @DeleteMapping("/{id}")
    public EmployeeModel deleteEmployee(@RequestBody EmployeeModel employee, @PathVariable Long id) {
        EmployeeModel employeeToDelete = repository.findById(id).get();
        repository.delete(employeeToDelete);
        return employeeToDelete;
    }
    
}
