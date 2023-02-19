package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;
    @PostMapping("/product")
    public String saveProduct(@RequestBody Product product){
        service.addProduct(product);
        return "product saved";
    }
    @GetMapping("/product/category")
    public List<Product> getProduct(@RequestParam String category){
      return service.getProduct(category);
    }
    @DeleteMapping("/delete/product")
    public String deleteProduct(@RequestParam Integer id){
        service.deleteProduct(id);
        return "product deleted";
    }
}
