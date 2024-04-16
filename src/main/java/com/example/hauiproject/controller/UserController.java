package com.example.hauiproject.controller;

import com.example.hauiproject.model.Book;
import com.example.hauiproject.service.BookService;
import com.example.hauiproject.service.CartService;
import com.example.hauiproject.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name= "HomeController",value = "/user")
public class UserController extends HttpServlet {
    BookService bookService = new BookService();
    CartService cartService = new CartService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "home":
                showHome(req,resp);
                break;
            case "cart":
                showCart(req,resp);
                break;
        }
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             String accountId =(String) req.getSession().getAttribute("accountId");
             try {
                 double price = cartService.getPrice((ArrayList<Book>)cartService.getCart(accountId));
                 List<Book> list = cartService.getCart(accountId);
                 req.setAttribute("totalmoney",price);
                 req.setAttribute("books", list);
             }catch (SQLException e ){

             }
             RequestDispatcher request = req.getRequestDispatcher("user/cart.jsp");
             request.forward(req,resp);
    }


    private void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        List<Book> book1 = bookService.getBookByCategory("tn");
        List<Book> book2 = bookService.getBookByCategory("kd");
        List<Book> book3 = bookService.getBookByCategory("tk");
        req.setAttribute("books1",book1);
        req.setAttribute("books2",book2);
        req.setAttribute("books3",book3);
        System.out.println(book1);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            switch (action) {
                case "addCart":
                    addCart(req, resp);
                    break;
            }
    }

    private void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String accountId = (String) req.getSession().getAttribute("accountId");
            String bookId = req.getParameter("bookId");
            try {
                cartService.add(accountId, bookId);
            }catch (SQLException e){

            }
    }
}
