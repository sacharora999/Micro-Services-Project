package com.example.empl.controller;

import com.example.empl.dto.ApiReponseDto;
import com.example.empl.dto.EmployeeDto;
import com.example.empl.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping("create")
    public ResponseEntity<EmployeeDto> saveEmpl(@RequestBody EmployeeDto employeeDto){
        EmployeeDto emDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(emDto, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<ApiReponseDto> getEmployeeById(@PathVariable("id") Long id){
        ApiReponseDto emDto = employeeService.getEmplById(id);
        return new ResponseEntity<>(emDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllAempoyees(){
        List<EmployeeDto> emDto = employeeService.getAllEmp();
        return new ResponseEntity<>(emDto, HttpStatus.OK);
    }

}
