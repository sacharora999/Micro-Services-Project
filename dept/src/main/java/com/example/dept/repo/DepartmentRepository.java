package com.example.dept.repo;

import com.example.dept.dto.DepartmentDto;
import com.example.dept.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
