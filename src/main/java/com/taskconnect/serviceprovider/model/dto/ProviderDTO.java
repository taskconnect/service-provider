package com.taskconnect.serviceprovider.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDTO {
    private Long id;
    private String fullName;
    private String email;
}
