package com.example.org.controller;

import com.example.org.dto.OrgDto;
import com.example.org.service.OrgService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/organizations")
public class OrginizationController {

    OrgService orgService;

    @PostMapping("create")
    public ResponseEntity<OrgDto> saveOrginization(@RequestBody OrgDto orgDto){
        OrgDto dto = orgService.createOrginization(orgDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("{orgcode}")
    public ResponseEntity<OrgDto> getOrginization(@PathVariable("orgcode") String orgcode){
        OrgDto dto = orgService.getOrginizationByCode(orgcode);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<OrgDto>> getOrginizations(){
        List<OrgDto> dtos = orgService.getAllOrginizations();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
