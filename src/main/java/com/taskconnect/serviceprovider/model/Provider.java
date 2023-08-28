package com.taskconnect.serviceprovider.model;

import com.taskconnect.serviceprovider.constants.RegexConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Provider {
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

    @ManyToMany
    @JoinTable(
            name = "provider_task",
            joinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id")
    )
    private Set<Task> tasksProvided;
}
