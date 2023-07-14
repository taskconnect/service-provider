package com.taskconnect.serviceprovider.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderDTO {
    private Long id;
    private String fullName;
    private String email;
}
