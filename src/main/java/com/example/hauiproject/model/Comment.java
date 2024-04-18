package com.example.hauiproject.model;

public class Comment {
    private String id;
    private String account_name;
    private String detail;

    public Comment(String id, String detail) {
        this.id = id;
        this.detail = detail;
    }

    public Comment(String id, String account_name, String detail) {
        this.id = id;
        this.account_name = account_name;
        this.detail = detail;
    }
}
