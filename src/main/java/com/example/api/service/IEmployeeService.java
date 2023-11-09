package com.example.api.service;

import com.example.api.dto.EmployeeDTO;
import com.example.api.dto.EmployeeSaveDTO;
import com.example.api.dto.EmployeeUpdateDTO;
import com.example.api.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    String addEmployee(EmployeeSaveDTO employeeSaveDTO);

    List<EmployeeDTO> getAllEmployees();

    String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);

    boolean deleteEmployee(int id);
}
