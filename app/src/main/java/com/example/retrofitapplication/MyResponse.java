package com.example.retrofitapplication;

import com.example.retrofitapplication.model.Product;

import java.util.List;

public class MyResponse {
    private int total;
    private int skip;
    private int limit;
    private List<Product> products;

    public MyResponse() {
    }

    public MyResponse(int total, int skip, int limit, List<Product> products) {
        this.total = total;
        this.skip = skip;
        this.limit = limit;
        this.products = products;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
