package com.example.org.mapper;


import com.example.org.dto.OrgDto;
import com.example.org.entity.Organization;

public class OrgMapper {

    public static Organization mapToOrganization(OrgDto oDto){
        Organization organization = new Organization(
                oDto.getOid(),
                oDto.getOrganizationName(),
                oDto.getOrganizationDescription(),
                oDto.getOrganizationCode(),
                oDto.getCreatedDate()
        );
        return  organization;
    }

    public static OrgDto getmapToOrgDto(Organization organization){
        OrgDto orgDto = new OrgDto(
                organization.getOid(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );
        return  orgDto;
    }



}
