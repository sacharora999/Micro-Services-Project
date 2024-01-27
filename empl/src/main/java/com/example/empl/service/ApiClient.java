package com.example.empl.service;

import com.example.empl.dto.DepartmentDto;
import com.example.empl.dto.OrgDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

    @GetMapping("api/departments/{departmentCode}")
    ResponseEntity<DepartmentDto> getDepartment(@PathVariable("departmentCode") String code);

    @GetMapping("api/organizations/{orgcode}")
    public ResponseEntity<OrgDto> getOrginization(@PathVariable("orgcode") String orgcode);

}
