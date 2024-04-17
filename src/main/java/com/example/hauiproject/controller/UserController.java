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

    public void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id = req.getParameter("id");
        try{
            Book book = bookService.getBook(Integer.parseInt(id));
            req.setAttribute("book", book);
        }catch (SQLException e){
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/product-details.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             int accountId = (int) req.getSession().getAttribute("accountId");
             try {
                 double price = cartService.getPrice((ArrayList<Book>)cartService.getCart(String.valueOf(accountId)));
                 List<Book> list = cartService.getCart(String.valueOf(accountId));
                 req.setAttribute("totalmoney",String.valueOf(price));
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
            int accountId = (int)req.getSession().getAttribute("accountId");
            String bookId = req.getParameter("bookId");
            cartService.add(bookId,String.valueOf(accountId) );
            resp.sendRedirect("http://localhost:8080/user?action=home");
    }
}
