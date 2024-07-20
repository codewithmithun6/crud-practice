package com.codewithmithun.controller;

import com.codewithmithun.entity.Address;
import com.codewithmithun.service.AddressService;
import com.codewithmithun.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/health")
    public String health(){
        return "Ok Address api is working fine";
    }

    // get all address
    @GetMapping("/")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    // delete address by id
    @DeleteMapping("/{addressId}")
    public String deleteAddressById(@PathVariable("addressId") Long addressId){
        addressService.deleteAddressById(addressId);

        return "Address Deleted ID: "+addressId+" Successfully";
    }


}
