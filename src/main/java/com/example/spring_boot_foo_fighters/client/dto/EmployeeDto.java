package com.example.spring_boot_foo_fighters.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    private Long id;
    private String name;
    private String surname;

}