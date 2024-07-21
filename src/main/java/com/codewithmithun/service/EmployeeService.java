package com.codewithmithun.service;

import com.codewithmithun.DTO.AddressDTO;
import com.codewithmithun.DTO.EmployeeDTO;
import com.codewithmithun.entity.Employee;


import java.util.List;

public interface EmployeeService {


    List<Employee> getAllEmployee() ;

    Employee createEmployee(Employee employee);
    void deleteEmployee(Long empId);
    Employee getEmployeeById(Long empId);
    Employee updateEmployee(Long empId, Employee updatedEmployee);
    List<Employee> findByContact(String contact);
    Employee addAddressToEmployee(Long employeeId, AddressDTO addressDTO);
    List<Employee> multipleSearchEmployees(String firstName, String lastName, String nickName, String emailId, String contact);

    EmployeeDTO createEmployeeWithoutAddress(EmployeeDTO employeeDTO);
}
