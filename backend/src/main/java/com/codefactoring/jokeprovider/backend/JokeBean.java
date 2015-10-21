package com.codefactoring.jokeprovider.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokeBean {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}