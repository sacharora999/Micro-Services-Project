package com.example.org.service;

import com.example.org.dto.OrgDto;
import com.example.org.entity.Organization;
import com.example.org.mapper.OrgMapper;
import com.example.org.repo.OrgRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrgizationServiceIMpl implements OrgService{

    OrgRepo orgRepo;
    @Override
    public OrgDto createOrginization(OrgDto orgDto) {
        OrgMapper orgMapper = new OrgMapper();
        Organization organization = orgMapper.mapToOrganization(orgDto);
        Organization savedOrganization = orgRepo.save(organization);
        OrgDto savedDto = orgMapper.getmapToOrgDto(savedOrganization);
        return savedDto;
    }

    @Override
    public OrgDto getOrginizationByCode(String code) {
        OrgMapper orgMapper = new OrgMapper();
        Organization organization = orgRepo.findByOrganizationCode(code);
        OrgDto savedDto = orgMapper.getmapToOrgDto(organization);
        return savedDto;

    }

    @Override
    public List<OrgDto> getAllOrginizations() {
        OrgMapper orgMapper = new OrgMapper();
        List<Organization> organizations = orgRepo.findAll();
        List<OrgDto> list = organizations.stream().map((org)->orgMapper.getmapToOrgDto(org)).collect(Collectors.toList());
        return list;
    }
}
