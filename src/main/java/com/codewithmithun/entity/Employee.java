package com.codewithmithun.entity;


import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_details")
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int empId;

    @NotBlank(message = "First name is mandatory")
//    @Min(value=2, message = "Minimum first name character is 2")
//    @Max(value=20, message = "Maximum first name character is 20")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
//    @Min(value=2, message = "Minimum last name character is 2")
//    @Max(value=20, message = "Maximum last name character is 20")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nick_name")
    private String nickName;


//    @NotBlank(message = "Age is mandatory")
//    @Min(value=18, message = "Minimum working age 18")
//    @Max(value=60, message = "Maximum working age 60")
    @Column(name = "age")
    private int age;

    @Column(name = "contact")
    @NotBlank(message = "Contact is mandatory")
//    @Min(value=10, message = "Minimum mobile number is 10")
//    @Max(value=10, message = "Maximum mobile number is 10")
    private String contact;


//    @NotBlank(message = "Salary is mandatory")
    @Column(name = "salary")
    private double salary;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "aadhar_card")
    private String aadharCard;



//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private List<Address> addresses;



}
