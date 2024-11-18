package com.example.demo.testcontainer.infra.repository;


import com.example.demo.testcontainer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}