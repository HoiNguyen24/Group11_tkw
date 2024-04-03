package com.example.hauiproject.service;

import com.example.hauiproject.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderService {
    Connection connection = GetConnect.getConnection();
    public void add(Order order) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO order (customer_id,date,price) values(?,?,?)");
        PreparedStatement order_detail = connection.prepareStatement("INSERT INTO order_detail (order_id,book_id) values(?,?)");
        preparedStatement.setString(1, String.valueOf(order.getCustomer().getId()));
        preparedStatement.setString(2, order.getDate().toString());
        preparedStatement.setString(3,String.valueOf(order.getPrice()));
        preparedStatement.executeUpdate();
    }
}
