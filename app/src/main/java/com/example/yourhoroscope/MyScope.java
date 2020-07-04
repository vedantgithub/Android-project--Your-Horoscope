package com.example.yourhoroscope;

public class MyScope {
    String title;
    String  scope;
    String hscope;
    String  image;

    public MyScope() {
    }

    public MyScope(String title, String scope) {
        this.title = title;
        this.scope = scope;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }



}
