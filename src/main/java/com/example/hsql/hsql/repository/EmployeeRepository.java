package com.example.hsql.hsql.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hsql.hsql.model.EmployeeModel;

public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long> {
}