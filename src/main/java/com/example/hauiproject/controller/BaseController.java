package com.example.hauiproject.controller;

import com.example.hauiproject.model.Account;
import com.example.hauiproject.model.Order;
import com.example.hauiproject.service.CustomerService;
import com.example.hauiproject.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="login",value="/login")
public class BaseController extends HttpServlet {
    CustomerService customerService = new CustomerService();
    OrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "login":
                showLogin(req, resp);
                break;
                case "register":
                    showRegister(req, resp);
                    break;
            case "showHome":
                showHome(req, resp);
                break;
            case "myorder":
                showMyOrder(req,resp);
                break;
        }
    }

    private void showMyOrder(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
        int accountId = (int) req.getSession().getAttribute("accountId");
        String account = customerService.getUsername(String.valueOf(accountId));
        List<Order> orders = orderService.getOrdersCustomer(String.valueOf(accountId));
        req.setAttribute("orders",orders);
        req.setAttribute("account",account);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/account-order.jsp");
        requestDispatcher.forward(req,resp);

    }

    public void showLogin(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req, resp);
    }
    public void showRegister(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(req,resp);
    }

    public void showHome(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "login":
                login(req, resp);
                break;
                case "register":
                    register(req, resp);
                    break;
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            int i = customerService.checkAccount(username, password);
            System.out.println(i);
            if(i != -1){
                HttpSession session = req.getSession();
                session.setAttribute("accountId",i);
                if(customerService.getRole(String.valueOf(i)))
                    resp.sendRedirect("http://localhost:8080/admin?action=home");
                else
                    resp.sendRedirect("http://localhost:8080/user?action=home");

            }else{
                resp.sendRedirect("http://localhost:8080/login?action=login");
            }
        }catch (SQLException e) {

        }
    }
}
