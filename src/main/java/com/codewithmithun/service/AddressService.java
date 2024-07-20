package com.codewithmithun.service;

import com.codewithmithun.entity.Address;

import java.util.List;

public interface AddressService {

     List<Address> getAllAddress();
     void deleteAddressById(Long addressId);
}
