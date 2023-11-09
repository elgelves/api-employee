package com.example.api.dto;

import lombok.Data;

@Data
public class EmployeeUpdateDTO {
    private Integer employeeId;
    private String employeeName;
    private String employeeEmail;
    private Integer employeeMobile;
}
