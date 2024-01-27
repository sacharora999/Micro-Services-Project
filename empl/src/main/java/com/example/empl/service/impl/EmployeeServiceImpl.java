package com.example.empl.service.impl;

import com.example.empl.dto.ApiReponseDto;
import com.example.empl.dto.DepartmentDto;
import com.example.empl.dto.EmployeeDto;
import com.example.empl.dto.OrgDto;
import com.example.empl.entity.Employee;
import com.example.empl.mapper.EmployeeMapper;
import com.example.empl.repo.EmployeeRepo;
import com.example.empl.service.ApiClient;
import com.example.empl.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepo employeeRepo;
//    private RestTemplate restTemplate;

    ApiClient apiClient;

    private WebClient webClient;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeMapper employeeMapper = new EmployeeMapper();
        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepo.save(employee);
        EmployeeDto eDto = employeeMapper.mapToEmployeeDto(savedEmployee);
        return eDto;
    }

    @Override
//    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDept")
//    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDept")
    public ApiReponseDto getEmplById(Long id) {

        EmployeeMapper employeeMapper = new EmployeeMapper();
        Employee savedEmployee = employeeRepo.findById(id).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+savedEmployee.getDepartmentCode(),
//                DepartmentDto.class);
//

        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/"+savedEmployee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
//        DepartmentDto departmentDto = apiClient.getDepartment(savedEmployee.getDepartmentCode()).getBody();
        OrgDto orgDto = webClient.get().uri("http://localhost:8083/api/organizations/"+savedEmployee.getOrganizationCode()).retrieve().bodyToMono(OrgDto.class).block();
//      DepartmentDto departmentDto = responseEntity.getBody();
        EmployeeDto employeeDto = employeeMapper.mapToEmployeeDto(savedEmployee);

        ApiReponseDto apiReponseDto = new ApiReponseDto();
        apiReponseDto.setEmployeeDto(employeeDto);
        apiReponseDto.setDepartmentDto(departmentDto);
        apiReponseDto.setOrgDto(orgDto);
        return apiReponseDto;
    }





    public ApiReponseDto getDefaultDept(Long id, Exception exception) {
        EmployeeMapper employeeMapper = new EmployeeMapper();
        Employee savedEmployee = employeeRepo.findById(id).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Dev Dept");
        EmployeeDto employeeDto = employeeMapper.mapToEmployeeDto(savedEmployee);

        ApiReponseDto apiReponseDto = new ApiReponseDto();
        apiReponseDto.setEmployeeDto(employeeDto);
        apiReponseDto.setDepartmentDto(departmentDto);
        return apiReponseDto;
    }





    @Override
    public List<EmployeeDto> getAllEmp() {
        EmployeeMapper employeeMapper = new EmployeeMapper();
        List<Employee> list = employeeRepo.findAll();
        List<EmployeeDto> listDto = list.stream().map((empl)->employeeMapper.mapToEmployeeDto(empl)).collect(Collectors.toList());
        return listDto;
    }
}
