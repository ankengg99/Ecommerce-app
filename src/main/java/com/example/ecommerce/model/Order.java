package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="orders")
public class Order {
    @Id
   private Integer orderId;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
   private User user;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
   private Product product;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
   private Address address;

}
