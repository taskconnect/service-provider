package com.taskconnect.serviceprovider.model;

import com.taskconnect.serviceprovider.constants.RegexConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Pattern(regexp = RegexConstants.FULL_NAME, message = "Por favor, insira seu nome completo.")
    private String fullName;

    @Column(nullable = false, unique = true)
    @Email(regexp = RegexConstants.EMAIL, message = "Email inválido.")
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = RegexConstants.PHONE_NUMBER, message = "Número de telefone inválido.")
    private String phoneNumber;
}
q