package com.example.spring_boot_foo_fighters.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    @NotBlank(message = "First name can not be null !")
    private String firstName;

    @NotNull(message = "Age can not be null !")
    private Integer age;

    @NotBlank
    private String phoneNumber;

}
