package com.example.hauiproject.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<BookOrder> books;
    private Customer customer;

    private String address;
    private Date date;
    private double price;

    public Order(int id, List<BookOrder> books, Customer customer, Date date, double price) {
        this.id = id;
        this.books = books;
        this.customer = customer;
        this.date = date;
        this.price = price;
    }

    public Order(int id, List<BookOrder> books, Customer customer, String address, Date date, double price) {
        this.id = id;
        this.books = books;
        this.customer = customer;
        this.address = address;
        this.date = date;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BookOrder> getBooks() {
        return books;
    }

    public void setBooks(List<BookOrder> books) {
        this.books = books;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
