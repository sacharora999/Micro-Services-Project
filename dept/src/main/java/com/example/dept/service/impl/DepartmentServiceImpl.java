package com.example.dept.service.impl;

import com.example.dept.dto.DepartmentDto;
import com.example.dept.entity.Department;
import com.example.dept.mapper.DepartmentMapper;
import com.example.dept.repo.DepartmentRepository;
import com.example.dept.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        DepartmentMapper departmentMapper = new DepartmentMapper();
        Department dept = departmentMapper.mapToDepartment(departmentDto);
        Department savedDept = departmentRepository.save(dept);
        return departmentMapper.mapToDepartmentDto(savedDept);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        DepartmentMapper departmentMapper = new DepartmentMapper();
        Department savedDept = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = departmentMapper.mapToDepartmentDto(savedDept);
        return departmentDto;
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        DepartmentMapper departmentMapper = new DepartmentMapper();
        List<Department> list = departmentRepository.findAll();
        List<DepartmentDto> listdto= list.stream().map((item)->departmentMapper.mapToDepartmentDto(item)).collect(Collectors.toList());
        return listdto;
    }
}
