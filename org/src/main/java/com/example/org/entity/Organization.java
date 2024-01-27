package com.example.org.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    @Column(nullable = false)
    private String organizationName;
    private String organizationDescription;
    @Column(nullable = false, unique = true)
    private String organizationCode;
    @CreationTimestamp
    private LocalDateTime createdDate;

}
