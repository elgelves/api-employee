package com.example.api.service.impl;

import com.example.api.dto.EmployeeDTO;
import com.example.api.dto.EmployeeSaveDTO;
import com.example.api.dto.EmployeeUpdateDTO;
import com.example.api.entity.Employee;
import com.example.api.repository.EmployeeRepository;
import com.example.api.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public String addEmployee(EmployeeSaveDTO employeeSaveDTO) {

        Employee employee = new Employee(
                employeeSaveDTO.getEmployeeName(),
                employeeSaveDTO.getEmployeeEmail(),
                employeeSaveDTO.getEmployeeMobile()
        );
        employeeRepository.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> getEmployees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee e : getEmployees) {
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    e.getEmployeeId(),
                    e.getEmployeeName(),
                    e.getEmployeeEmail(),
                    e.getEmployeeMobile()
            );
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {

        if (employeeRepository.existsById(employeeUpdateDTO.getEmployeeId())) {
            Employee employee = employeeRepository.getById(employeeUpdateDTO.getEmployeeId());

            employee.setEmployeeName(employeeUpdateDTO.getEmployeeName());
            employee.setEmployeeEmail(employeeUpdateDTO.getEmployeeEmail());
            employee.setEmployeeMobile(employeeUpdateDTO.getEmployeeMobile());

            employeeRepository.save(employee);
        } else {
            System.out.println("Employee ID not found");
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            System.out.println("Employee ID not found");
        }
        return true;
    }

}
