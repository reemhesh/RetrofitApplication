package com.example.retrofitapplication.network;

import android.util.Log;

import com.example.retrofitapplication.MyResponse;
import com.example.retrofitapplication.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_Client {

    ProductService apiService;

    private static final String BASE_URL = "https://dummyjson.com/";
    private static API_Client client = null;
    private NetworkDelegate networkDelegate;

    private API_Client(NetworkDelegate networkDelegate) {
        this.networkDelegate = networkDelegate;
    }

    public static API_Client getInstance(NetworkDelegate networkDelegate) {
        if (client == null) {
            client = new API_Client(networkDelegate);
        }
        return client;
    }

    public void startCall() {
        Log.i("ApiClient", "startCall: ");
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiService = retrofit.create(ProductService.class);

        Call<MyResponse> products = apiService.getProducts();

        products.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    MyResponse myResponse = response.body();
                    List<Product> products = myResponse.getProducts(); // Retrieve the list of products from the MyResponse object
                    networkDelegate.sucess(products);
                } else {
                    Log.e("ApiClient", "Error in retrofit");
                }
            }


            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                networkDelegate.failure(t.getMessage());
            }
        });
    }
}


