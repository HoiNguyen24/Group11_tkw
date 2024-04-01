package com.example.hauiproject.service;

import com.example.hauiproject.model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostService {
    Connection connection = GetConnect.getConnection();

    public List<Comment> getComments(int bookId) throws SQLException {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        PreparedStatement preparedStatement = connection.prepareStatement("select userId,content from comment where book_id = ?");
        preparedStatement.setString(1,String.valueOf(bookId));
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()) {
            Comment comment = new Comment(rs.getString("userId"),rs.getString("content"));
            comments.add(comment);
        }
        return comments;
    }
}
