package com.example.dept.controller;

import com.example.dept.dto.DepartmentDto;
import com.example.dept.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {
    DepartmentService departmentService;

    @PostMapping("create")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto dto = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("departmentCode") String code){
        DepartmentDto dto = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllSavedDepts(){
        List<DepartmentDto> listDept = departmentService.getAllDepartment();
        return new ResponseEntity<>(listDept, HttpStatus.OK);
    }
}
