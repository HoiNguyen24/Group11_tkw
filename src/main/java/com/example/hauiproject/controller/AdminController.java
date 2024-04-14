package com.example.hauiproject.controller;

import com.example.hauiproject.model.Book;
import com.example.hauiproject.service.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "adminController",value = "/admin")
@MultipartConfig(
        location = "C:\\Users\\Admin\\IdeaProjects\\hauiProject\\image",
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10
)

public class AdminController extends HttpServlet {

    BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch(action) {
            case "home":
                showHome(req, resp);
                break;
            case "add":
                showAdd(req, resp);
                break;
        }
    }

    public void showHome(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
               List<Book> books = bookService.findall();
               req.setAttribute("books", books);
               RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin/home.jsp");
               requestDispatcher.forward(req, resp);
    }
    public void showAdd(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin/add.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "addBook":
                addBook(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
        }

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.delete(id);
    }
    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        double price  = Double.valueOf(req.getParameter("price"));
        System.out.println(price);
        bookService.add(new Book(-1,name,author,category,price));
        Part part = req.getPart("5");
        part.write(bookService.getRecently()+".png");
    }
}
