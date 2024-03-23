package com.example.hauiproject.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name= "BookController",value = "/home")
public class BookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "login":
                showLogin(req, resp);
                break;
            case "register":
                showRegister(req,resp);
                break;
        }
    }

    private void showLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("loginmodal","display: block !important");
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("account/register.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){

        }
    }
    private void createAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("ac-pass");
        String repassword = req.getParameter("ac-repass");
        if(password.equals(repassword)){
            String username = req.getParameter("ac-username");

            String phonenumber = req.getParameter("ac-phonenumber");
            String name = req.getParameter("ac-name");
        }
        resp.sendRedirect("/home");
    }
}
