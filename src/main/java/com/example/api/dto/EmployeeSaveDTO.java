package com.example.api.dto;

import lombok.Data;

@Data
public class EmployeeSaveDTO {
    private String employeeName;
    private String employeeEmail;
    private Integer employeeMobile;
}
