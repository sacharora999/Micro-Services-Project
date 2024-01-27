package com.example.org.service;

import com.example.org.dto.OrgDto;

import java.util.List;

public interface OrgService {

    OrgDto createOrginization(OrgDto orgDto);
    OrgDto getOrginizationByCode(String code);
    List<OrgDto> getAllOrginizations();

}
