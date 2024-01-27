package com.example.empl.service;

import com.example.empl.dto.ApiReponseDto;
import com.example.empl.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    ApiReponseDto getEmplById(Long id);
    List<EmployeeDto> getAllEmp();
}
