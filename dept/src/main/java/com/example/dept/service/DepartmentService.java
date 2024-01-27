package com.example.dept.service;

import com.example.dept.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String departmentCode);
    List<DepartmentDto> getAllDepartment();

}
