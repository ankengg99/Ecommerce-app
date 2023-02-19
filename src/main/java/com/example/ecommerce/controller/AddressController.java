package com.example.ecommerce.controller;

import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.model.Address;
import com.example.ecommerce.service.AddressService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService service;

    @PostMapping("/address")
    public String saveAddress(@RequestBody String address){
        JSONObject jsonObject=new JSONObject(address);
        Address address1=service.setAddress(jsonObject);
        service.addAddress(address1);
        return "address saved";
    }

}
