package com.example.hauiproject.service;

import com.example.hauiproject.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CartService {
    Connection connection = GetConnect.getConnection();
    public void add(Book product,String id_customer) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Cart (id,book_id) VALUES (?,?)");
        statement.setString(1,id_customer);
        statement.setString(2,String.valueOf(product.getId()));
        statement.executeUpdate();
    }
    public List<Book> getCart(String id_customer) throws SQLException {
        List<Book> list = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT c.id_book,b.name,b.author,b.category,b.price from cart c join book b on b.id = c.book_id where c.id = ?");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            list.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
        }
        return list;
    }

    public double getPrice(ArrayList<Book> list){
        double price = 0;
        for (Book b : list){
            price += b.getPrice();
        }
        return price;
    }


}
