package com.example.hauiproject.service;

import com.example.hauiproject.model.Account;
import com.example.hauiproject.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerService {
          Connection connection = GetConnect.getConnection();
          public void add(Account account, Customer customer) throws Exception {
              PreparedStatement customer_connect = connection.prepareStatement("INSERT INTO customer ( name,phonenumber ) VALUES(?,?)");
              PreparedStatement account_connect = connection.prepareStatement("INSERT INTO account ( username,password,role ) VALUES(?,?,?)");
              customer_connect.setString(1,customer.getName());
              customer_connect.setString(2,customer.getPhonenumber());
              customer_connect.execute();
              account_connect.setString(1,account.getUsername());
              account_connect.setString(2,account.getPassword());
              account_connect.setString(3,"user");
              account_connect.execute();
          }
}
