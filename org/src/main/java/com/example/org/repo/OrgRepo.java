package com.example.org.repo;

import com.example.org.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepo extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String code);
}