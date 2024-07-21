package com.codewithmithun.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private int empId;
    private String firstName;
    private String lastName;
    private String nickName;
    private int age;
    private String contact;
    private double salary;
    private String emailId;
    private String aadhaarCard;

}
