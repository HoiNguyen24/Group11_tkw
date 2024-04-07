package com.example.hauiproject.service;

import com.example.hauiproject.model.Book;
import com.example.hauiproject.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Order getOrder(String id_order) throws SQLException {
        List<Book> books = new ArrayList<>();
        BookService bookService = new BookService();
        PreparedStatement ps = connection.prepareStatement("SELECT book_id,sum(quantity) as quantity FROM order_detail where order_id = ? group by book_id");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            books.add(bookService.getBook(rs.getInt("book_id")));
        }
        ps.setString(1, id_order);
        ResultSet rs2 = ps.executeQuery();
        return new Order (rs2.getInt(""))
    }
    public List<Order> getOrdersCustomer(String id) throws SQLException {
        PreparedStatement order_detail = connection.prepareStatement("SELECT * from order where customer_id = ?");
        order_detail.setString(1,id);
        ResultSet result = order_detail.executeQuery();
        while (result.next()) {

        }
    }
}
