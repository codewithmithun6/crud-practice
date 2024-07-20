package com.codewithmithun.controller;

import com.codewithmithun.DTO.AddressDTO;
import com.codewithmithun.entity.Employee;
import com.codewithmithun.service.AddressService;
import com.codewithmithun.service.EmployeeService;
import com.codewithmithun.service.impl.AddressServiceImpl;
import com.codewithmithun.service.impl.EmployeeServiceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Slf4j
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;



    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/health")
    public String health(){
        log.info("Logger is working fine");
        return "Ok API is working fine.";
    }

    // get all employee
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){

        return employeeService.getAllEmployee();

    }

    // create employee
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    // delete employee by id
    @DeleteMapping("/employee/{empId}")
    public String deleteEmployee(@PathVariable("empId") Long empId){
        employeeService.deleteEmployee(empId);

        return "Employee ID: "+ empId+" deleted successfully";
    }

    // get employee by id
    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") Long empId){
        return employeeService.getEmployeeById(empId);

    }
    // update employee
    @PutMapping("/employee/{empId}")
    public Employee updateEmployee(@PathVariable("empId") Long empId, @RequestBody Employee employee){
        return employeeService.updateEmployee(empId,employee);

    }

    // find by contact number
    @GetMapping("/employee/search/{contact}")
    public List<Employee> findByContact(@PathVariable("contact") String contact){

        return employeeService.findByContact(contact);

    }

    // create address of existing employee using employee id
    @PostMapping("/employee/{id}/addresses")
    public Employee addAddressToEmployee(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) {
        return employeeService.addAddressToEmployee(id, addressDTO);
    }

    // find by firstName or lastName or nickName or email id or contact
    @GetMapping("/employee/globalSearch")
    public List<Employee> searchEmployees(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String nickName,
            @RequestParam(required = false) String emailId,
            @RequestParam(required = false) String contact ) {
        return employeeService.multipleSearchEmployees(firstName, lastName, nickName, emailId, contact);
    }

//    // find by address by city or state
//    @GetMapping("/employee/address")
//    public List<Employee> findByCityOrState(
//            @RequestParam(required = false) String city,
//            @RequestParam(required = false) String state ){
//        return addressService.findByCityOrState(city,state);
//
//
//    }

}
