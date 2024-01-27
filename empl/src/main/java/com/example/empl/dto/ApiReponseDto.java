package com.example.empl.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiReponseDto {

    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
    private OrgDto orgDto;
}
