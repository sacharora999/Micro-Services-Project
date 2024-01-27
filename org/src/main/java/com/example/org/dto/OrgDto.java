package com.example.org.dto;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrgDto {


    private Long oid;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private LocalDateTime createdDate;
}
