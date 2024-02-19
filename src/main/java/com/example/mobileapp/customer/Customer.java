package com.example.mobileapp.customer;

import com.example.mobileapp.order.CustomerOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String address;

    @OneToOne
    private com.example.mobileapp.cart.Cart Cart;

    @OneToMany
    private List<CustomerOrder> orders = new ArrayList<>();


    public Customer(String name, String email, String password, com.example.mobileapp.cart.Cart Cart, List<CustomerOrder> orders, String address) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.Cart = Cart;
        this.orders = orders;
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public com.example.mobileapp.cart.Cart getCart() {
        return Cart;
    }

    public void setCart(com.example.mobileapp.cart.Cart Cart) {
        this.Cart = Cart;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }

}