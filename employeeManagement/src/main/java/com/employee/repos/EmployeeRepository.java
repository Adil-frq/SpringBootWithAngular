package com.employee.repos;

import com.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Optional<Employee> deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
