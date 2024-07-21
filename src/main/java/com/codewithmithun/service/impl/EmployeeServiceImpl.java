package com.codewithmithun.service.impl;

import com.codewithmithun.DTO.AddressDTO;
import com.codewithmithun.DTO.EmployeeDTO;
import com.codewithmithun.entity.Address;
import com.codewithmithun.entity.Employee;
import com.codewithmithun.mapper.EmployeeMapper;
import com.codewithmithun.repository.EmployeeRepository;
import com.codewithmithun.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {

        log.info("Employee Created...");
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public Employee getEmployeeById(Long empId) {

        return employeeRepository.findById(empId).orElse(null);
    }


    @Transactional
    @Override
    public Employee updateEmployee(Long empId, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(empId).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setNickName(updatedEmployee.getNickName());
            existingEmployee.setEmailId(updatedEmployee.getEmailId());
            existingEmployee.setContact(updatedEmployee.getContact());
            existingEmployee.setAge(updatedEmployee.getAge());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setAadhaarCard(EmployeeMapper.formatAadhaarNumber(updatedEmployee.getAadhaarCard()));
//            existingEmployee.setAddresses(updatedEmployee.getAddresses()); // we can use this one also for update
            // below is better way to update address
            // Update addresses
            List<Address> newAddresses = updatedEmployee.getAddresses();
            if (newAddresses != null) {
                existingEmployee.getAddresses().clear();
                for (Address address : newAddresses) {
                    address.setEmployee(existingEmployee);
                    existingEmployee.getAddresses().add(address);
                }
            }

            return employeeRepository.save(existingEmployee);
        }

        return null;
    }

    @Override
    public List<Employee> findByContact(String contact) {

        return employeeRepository.findByContact(contact);
    }

    // DTO
    public Employee addAddressToEmployee(Long employeeId, AddressDTO addressDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            Address address = new Address();
            address.setStreet(addressDTO.getStreet());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setZipcode(addressDTO.getZipcode());
            address.setCountry(addressDTO.getCountry());
            address.setLandmark(addressDTO.getLandmark());
            address.setEmployee(employee);

            employee.getAddresses().add(address);
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    @Override
    public List<Employee> multipleSearchEmployees(String firstName, String lastName, String nickName, String emailId, String contact,String aadhaarCard) {
        return employeeRepository.findByFirstNameOrLastNameOrNickNameOrEmailIdOrContactOrAadhaarCard(firstName, lastName, nickName, emailId, contact,aadhaarCard);
    }

    @Override
    public EmployeeDTO createEmployeeWithoutAddress(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(savedEmployee);
    }


}
