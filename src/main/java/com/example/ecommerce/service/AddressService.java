package com.example.ecommerce.service;

import com.example.ecommerce.dao.AddressRepository;
import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.model.Address;
import com.example.ecommerce.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository repository;
    @Autowired
    UserRepository userRepository;
    public void addAddress(Address address){
        repository.save(address);
    }
   public Address setAddress(JSONObject jsonObject){
        Address address=new Address();
        address.setAddressId(jsonObject.getInt("addressId"));
        address.setLandmark(jsonObject.getString("landmark"));
        address.setState(jsonObject.getString("state"));
        address.setZipcode(jsonObject.getString("zipcode"));
        address.setCityName(jsonObject.getString("cityName"));
        address.setPhoneNo(jsonObject.getString("phoneNo"));
        int id= jsonObject.getInt("user");
        User user=userRepository.findById(id).get();
        address.setUser(user);
        return address;
   }
}
