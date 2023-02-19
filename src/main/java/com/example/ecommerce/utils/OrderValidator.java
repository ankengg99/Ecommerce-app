package com.example.ecommerce.utils;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class OrderValidator {
public static List<String> validator(JSONObject jsonObject){
    List<String> error=new ArrayList<>();
    if(!jsonObject.has("user")){
        error.add("user");
    }
    if(!jsonObject.has("address")){
        error.add("address");
    }
    if(!jsonObject.has("product")){
        error.add("product");
    }
    if(!jsonObject.has("orderId")){
        error.add("orderId");
    }
    return error;
}
}
