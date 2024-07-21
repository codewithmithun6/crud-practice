package com.codewithmithun.mapper;

import com.codewithmithun.DTO.EmployeeDTO;
import com.codewithmithun.entity.Employee;

public class EmployeeMapper {

    // entity to dto
    public static EmployeeDTO toDTO(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmpId(employee.getEmpId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setNickName(employee.getNickName());
        dto.setFirstName(employee.getFirstName());
        dto.setAge(employee.getAge());
        dto.setContact(employee.getContact());
        dto.setSalary(employee.getSalary());
        dto.setEmailId(employee.getEmailId());
        dto.setAadhaarCard(employee.getAadhaarCard());
        return dto;
    }


    // dto to entity

    public static Employee toEntity(EmployeeDTO dto){
        Employee employee = new Employee();
        employee.setEmpId(dto.getEmpId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setNickName(dto.getNickName());
        employee.setFirstName(dto.getFirstName());
        employee.setAge(dto.getAge());
        employee.setContact(dto.getContact());
        employee.setSalary(dto.getSalary());
        employee.setEmailId(dto.getEmailId());
        employee.setAadhaarCard(formatAadhaarNumber(dto.getAadhaarCard()));
        return employee;
    }

    // aadhar number format after 4 digit will be space eg: 1234 5678 9012

    public static String formatAadhaarNumber(String aadhaarNumber) {
        return aadhaarNumber.replaceAll("(\\d{4})(\\d{4})(\\d{4})", "$1 $2 $3");
    }
}
