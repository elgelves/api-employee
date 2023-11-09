package com.example.api.controller;

import com.example.api.dto.EmployeeDTO;
import com.example.api.dto.EmployeeSaveDTO;
import com.example.api.dto.EmployeeUpdateDTO;
import com.example.api.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {

    private final IEmployeeService employeeService;

    // Colocar el controlador necesario para ejecutar la aplicación

    @GetMapping("/getAllEmployees")
    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeDTO> allEmployes = employeeService.getAllEmployees();
        return allEmployes;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        String id = employeeService.updateEmployee(employeeUpdateDTO);
        return id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable (value="id") int id) {
        boolean deleteEmployee = employeeService.deleteEmployee(id);
        return "deleted";
    }
}
