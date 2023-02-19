package com.example.ecommerce.service;

import com.example.ecommerce.dao.AddressRepository;
import com.example.ecommerce.dao.OrderRepository;
import com.example.ecommerce.dao.ProductRepository;
import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.model.Address;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AddressRepository addressRepository;
    public void placeOrder(Order order){
        repository.save(order);

    }
    public Order setOrder(JSONObject jsonObject){
      Order order=new Order();
      order.setOrderId(jsonObject.getInt("orderId"));
      User user=userRepository.findById(jsonObject.getInt("user")).get();
      order.setUser(user);
      Address address=addressRepository.findById(jsonObject.getInt("address")).get();
      order.setAddress(address);
        Product product=productRepository.findById(jsonObject.getInt("product")).get();
        order.setProduct(product);
        return order;
    }
    public JSONArray getOrder(Integer id){
       Order o=repository.findById(id).get();
       JSONArray array=new JSONArray();

           JSONObject json=new JSONObject();
           json.put("orderId",o.getOrderId());
           json.put("productId",o.getProduct().getProductId());
           json.put("userId",o.getUser().getUserId());
           json.put("addressId",o.getAddress().getAddressId());
           array.put(json);

       return array;
    }

}
