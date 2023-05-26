package com.example.retrofitapplication.network;

import com.example.retrofitapplication.model.Product;

import java.util.List;

public interface NetworkDelegate {
    public void sucess(List<Product> products);
    public void failure(String errorMsg);
    
}
