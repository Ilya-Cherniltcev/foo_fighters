package com.example.spring_boot_foo_fighters.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    @NotBlank
    private String firstName;

    @NotNull
    private Integer age;

    private Boolean isVerified;

    @NotBlank
    private String phoneNumber;

}
