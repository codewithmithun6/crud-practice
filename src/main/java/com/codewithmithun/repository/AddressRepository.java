package com.codewithmithun.repository;

import com.codewithmithun.entity.Address;
import com.codewithmithun.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
//    List<Employee> findByCityOrState(String city, String state);
}
