package com.codewithmithun.repository;

import com.codewithmithun.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByContact(String contact);


// multiple search
    List<Employee> findByFirstNameOrLastNameOrNickNameOrEmailIdOrContactOrAadhaarCard(String firstName, String lastName, String nickName, String emailId, String contact,String aadhaarCard);



    // multiple search with custom query (both query will work custom and default)

//    @Query("SELECT e FROM Employee e WHERE " +
//            "(:firstName IS NULL OR e.firstName LIKE %:firstName%) AND " +
//            "(:lastName IS NULL OR e.lastName LIKE %:lastName%) AND " +
//            "(:nickName IS NULL OR e.nickName LIKE %:nickName%) AND " +
//            "(:emailId IS NULL OR e.emailId LIKE %:emailId%) AND " +
//            "(:contact IS NULL OR e.contact LIKE %:contact%)")
//    List<Employee> findByFirstNameOrLastNameOrNickNameOrEmailIdOrContact(
//            @Param("firstName") String firstName,
//            @Param("lastName") String lastName,
//            @Param("nickName") String nickName,
//            @Param("emailId") String emailId,
//            @Param("contact") String contact
//
//    );
}
