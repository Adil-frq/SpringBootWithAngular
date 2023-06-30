package com.employee.util;

import com.employee.dto.request.EmployeeRequest;
import com.employee.dto.response.EmployeeResponse;
import com.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeConvertor {
    public EmployeeResponse entityToDto(Employee e) {
        EmployeeResponse response = new EmployeeResponse();
        response.setName(e.getName());
        response.setEmail(e.getEmail());
        response.setJobTitle(e.getJobTitle());
        response.setPhone(e.getPhone());
        response.setImageUrl(e.getImageUrl());
        return response;
    }

    public List<EmployeeResponse> entityToDto(List<Employee> employees) {
        List<EmployeeResponse> responses = new ArrayList<>();
        for(Employee emp : employees) {
            responses.add(entityToDto(emp));
        }
        return responses;

    }

    public Employee dtoToEntity(EmployeeRequest request) {
        Employee employee = new Employee();
       // employee.setId(request.getId());
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setJobTitle(request.getJobTitle());
        employee.setPhone(request.getPhone());
        employee.setImageUrl(request.getImageUrl());
        return employee;
    }
}
