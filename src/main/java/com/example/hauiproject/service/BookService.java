package com.example.hauiproject.service;

import com.example.hauiproject.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService<Book>{

    Connection connection = null;

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthaui","root","admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
  public Book show(int index){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from book where id = ?");
            preparedStatement.setString(1,String.valueOf(index));
            ResultSet book = preparedStatement.executeQuery();
            if(book.next()){
                Statement statement = connection.createStatement();
                ResultSet author = statement.executeQuery("SELECT name FROM author where id = "+ Integer.parseInt(book.getString(3)));
                if(author.next())
                return new Book(book.getInt(1),book.getString(2),author.getString(1),book.getString(4),book.getDouble(5));
            }
        }catch (Exception e){
        }
        return null;
    }

    @Override
    public void add(Book book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book (name,author,category,price) values (?,?,?,?)");
            preparedStatement.setString(1,book.getName());
            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT id from author where name = ?");
            preparedStatement1.setString(1,book.getAuthor());
            ResultSet id_author = preparedStatement1.executeQuery();
            if(!id_author.next()){
                PreparedStatement authorStatement = connection.prepareStatement("INSERT INTO author (name) values (?)");
                authorStatement.setString(1,book.getAuthor());
                authorStatement.executeUpdate();
            }
            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT id from author where name = ?");
            preparedStatement2.setString(1,book.getAuthor());
            ResultSet id_author1 = preparedStatement2.executeQuery();
            if(id_author1.next()){
                preparedStatement.setString(2,id_author.getString(1));
                preparedStatement.setString(3,book.getCategory());
                preparedStatement.setString(4,String.valueOf(book.getPrice()));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("loi o day dm");
        }
    }

    @Override
    public List<Book> findall() {
        List<Book> books_list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet books = statement.executeQuery("SELECT * from book");
            PreparedStatement author = connection.prepareStatement("SELECT name from author where id = ?");
            while (books.next()){
                  author.setString(1,books.getString(3));
                  ResultSet author_rs = author.executeQuery();
                  books_list.add(new Book(books.getInt(1),books.getString(2),author_rs.getString(3),books.getString(4),books.getDouble(5)));
            }
        }catch (Exception e){

        }
        return books_list;
    }

    @Override
    public void edit(int index, Book book) {

    }

    @Override
    public void delete(int id) {
           try {
               Statement statement = connection.createStatement();
               statement.executeUpdate("DELETE from book where id = " + id);
           }catch (Exception e){

           }
    }

    @Override
    public int findIndexById(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id from book where id ="+ id);
            return rs.getInt(1);
        }catch (Exception e){
        }
        return -1;
    }
}
