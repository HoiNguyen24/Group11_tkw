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
import java.io.IOException;
import java.util.Collection;

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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/add.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action){
            case "addBook":
                addBook(req,resp);
                break;
        }

    }
    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("1");
        String author = req.getParameter("2");
        String category = req.getParameter("3");
        System.out.println(category);
        double price  = Double.valueOf(req.getParameter("price"));
        System.out.println(price);
        bookService.add(new Book(-1,name,author,category,price));
        Part part = req.getPart("5");
        part.write("1.png");
        System.out.println(part.getSubmittedFileName());
        String file = req.getParameter("5");
    }
}
