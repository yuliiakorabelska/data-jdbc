package com.korabelska.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DoctorDto {

    private Long hospitalId;

    private Long departmentId;

    private String firstName;

    private LocalDate dateOfBirth;
}