package com.example.hauiproject.service;

import com.example.hauiproject.model.Account;
import com.example.hauiproject.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerService {
          Connection connection = GetConnect.getConnection();
          public void add(Account account, Customer customer) throws Exception {
              PreparedStatement customer_connect = connection.prepareStatement("INSERT INTO customer ( name,phonenumber ) VALUES(?,?)");
              PreparedStatement account_connect = connection.prepareStatement("INSERT INTO account ( username,password,role ) VALUES(?,?,?)");
              customer_connect.setString(1,customer.getName());
              customer_connect.setString(2,customer.getPhonenumber());
              customer_connect.execute();
              account_connect.setString(1,account.getUsername());
              account_connect.setString(2,account.getPassword());
              account_connect.setString(3,"user");
              account_connect.execute();
          }
          public int checkAccount(String username, String password) throws Exception {
              PreparedStatement st = connection.prepareStatement("SELECT * from account where username = ? and password = ?");
              st.setString(1,username);
              st.setString(2,password);
              ResultSet rs = st.executeQuery();
              if(rs.next()) {
                  return rs.getInt("id");
              }else
                  return -1;
          }
          public void addAdress(String address,String customer_id) throws Exception {
              PreparedStatement st = connection.prepareStatement("INSERT INTO adresses (id_customer,address) values (?,?)");
              st.setString(1,customer_id);
              st.setString(2,address);
              st.executeUpdate();
          }
          public void deleteAddress(String id_address) throws Exception {
              PreparedStatement st = connection.prepareStatement("delete from address where id = ?");
              st.setString(1,id_address);
              st.executeUpdate();
          }

}
