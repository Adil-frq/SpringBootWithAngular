package com.employee.service;

import com.employee.dto.request.EmployeeRequest;
import com.employee.dto.response.EmployeeResponse;
import com.employee.entity.Employee;
import com.employee.exceptions.EmployeeNotFoundException;
import com.employee.repos.EmployeeRepository;
import com.employee.util.EmployeeConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private EmployeeConvertor convertor;

    public EmployeeResponse addEmployee(EmployeeRequest request) {
        Employee emp = convertor.dtoToEntity(request);
        emp.setEmployeeCode(UUID.randomUUID().toString());
        Employee employee = repository.save(emp);
        EmployeeResponse response = convertor.entityToDto(employee);
        return response;
    }

    public List<EmployeeResponse> findAllEmployees() {
       List<Employee> employees =  repository.findAll();
       List<EmployeeResponse> responses = convertor.entityToDto(employees);
        return responses;
    }

    public EmployeeResponse updateEmployee(EmployeeRequest request) {
        Employee employee = convertor.dtoToEntity(request);
        Employee emp = repository.save(employee);
        return convertor.entityToDto(emp);
    }

    public EmployeeResponse deleteEmployeeById(Long id) {
        Optional<Employee> employee = repository.deleteEmployeeById(id);
        Employee employee1 = employee.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for given id :" + id));
        return convertor.entityToDto(employee1);
    }

    public EmployeeResponse findEmployeeById(Long id) {
        Optional<Employee> employee = repository.findEmployeeById(id);
        Employee employee1 = employee.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for given id :" + id));
        return convertor.entityToDto(employee1);
    }
 }
