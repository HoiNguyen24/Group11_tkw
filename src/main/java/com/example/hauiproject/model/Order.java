package com.example.hauiproject.model;

import java.sql.Date;
import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Book> books;
    private Customer customer;

    private Date date;

    private double price;

    public Order(int id, ArrayList<Book> books, Customer customer, Date date, double price) {
        this.id = id;
        this.books = books;
        this.customer = customer;
        this.date = date;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
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
