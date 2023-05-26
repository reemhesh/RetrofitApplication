package com.example.retrofitapplication.allProducts.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.retrofitapplication.R;
import com.example.retrofitapplication.allProducts.view.AllProductListner;
import com.example.retrofitapplication.db.Repository;
import com.example.retrofitapplication.favProducts.view.ProductAdapter;
import com.example.retrofitapplication.model.Product;
import com.example.retrofitapplication.network.NetworkDelegate;

import java.util.List;

public class AllProductsActivity extends AppCompatActivity  implements NetworkDelegate, AllProductListner {
    RecyclerView recycleView;
    ProductAdapter productAdapter;
    RecyclerView.LayoutManager layoutManager;
    ImageView imageView;
    Repository repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        recycleView = findViewById(R.id.recyclerViewProducts);
        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);
    }

    @Override
    public void sucess(List<Product> products) {
        productAdapter.setList(products);
        productAdapter.notifyDataSetChanged();
    }

    @Override
    public void failure(String errorMsg) {
        recycleView.setVisibility(View.GONE);
        imageView.setVisibility(View.VISIBLE);
    }


    @Override
    public void onClick(Product product) {

            repo.insert(product);
      productAdapter.notifyDataSetChanged();

    }
}