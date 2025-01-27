package com.example.mobileapp.customer;

import com.example.mobileapp.cart.Cart;

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
    private String gender;
    private String address;


    @OneToOne
    private Cart Cart;




    public Customer(String name, String email, String password,String gender, Cart Cart,String address) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender=gender;
        this.Cart = Cart;

        this.address=address;
    }

    public Customer() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(int i, String alice, String mail, String alice123, String male, String ywavcmhagvf) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Cart getCart() {
        return Cart;
    }

    public void setCart(Cart Cart) {
        this.Cart = Cart;
    }



}