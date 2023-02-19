package com.example.ecommerce.service;

import com.example.ecommerce.dao.ProductRepository;
import com.example.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;
    public void addProduct(Product product){
      repository.save(product);
    }
    public List<Product> getProduct(String category){
        List<Product> list=new ArrayList<>();
        List<Product> products=repository.findAll();
        for(Product p:products){
            if(p.getCategory().equals(category)){
                list.add(p);
            }
        }
        return list;
    }
    public void deleteProduct(Integer id){
        repository.deleteById(id);
    }
}
