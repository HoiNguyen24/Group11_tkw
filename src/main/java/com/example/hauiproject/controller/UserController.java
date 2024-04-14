package com.example.hauiproject.controller;

import com.example.hauiproject.model.Book;
import com.example.hauiproject.service.BookService;
import com.example.hauiproject.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name= "HomeController",value = "/user")
public class UserController extends HttpServlet {
    BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "home":
                showHome(req,resp);
                break;
        }
    }

    private void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
            List<Book> book1 = bookService.getBookByCategory("tn");
            List<Book> book2 = bookService.getBookByCategory("kd");
            List<Book> book3 = bookService.getBookByCategory("tk");
            req.setAttribute("book1",book1);
            req.setAttribute("book2",book2);
            req.setAttribute("book3",book3);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
