package com.example.retrofitapplication.network;

import com.example.retrofitapplication.MyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {

    @GET("products")
    Call<MyResponse> getProducts();
}
