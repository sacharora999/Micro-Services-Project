package com.example.empl.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrgDto {

    private Long oid;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private LocalDateTime createdDate;

}
