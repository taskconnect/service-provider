package com.taskconnect.serviceprovider.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //? Wouldn't it be better if taskCategory were an ENUM with a few categories?
    private String taskCategory;
    private String description;
    private Double pricePerHour;

    @JsonIgnore
    @ManyToMany(mappedBy = "tasksProvided")
    private Set<Provider> providers;
}
