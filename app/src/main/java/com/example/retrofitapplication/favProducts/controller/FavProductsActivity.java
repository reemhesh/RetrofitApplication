package com.example.retrofitapplication.favProducts.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.retrofitapplication.R;
import com.example.retrofitapplication.db.Repository;
import com.example.retrofitapplication.favProducts.view.ProductAdapter;
import com.example.retrofitapplication.favProducts.view.onFavouriteClickListener;
import com.example.retrofitapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class FavProductsActivity extends AppCompatActivity implements onFavouriteClickListener {
RecyclerView favRecycleView;
ProductAdapter favAdapter;
RecyclerView.LayoutManager layoutManager;
ImageView imageView;
Repository repo;
ArrayList<Product>products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_products);
        favRecycleView = findViewById(R.id.recyclerViewFavProducts);
        favAdapter=new ProductAdapter(this,products,this);
      // imageView=findViewById(R.layout.thumbnailImageView);
        layoutManager = new LinearLayoutManager(this);
        favRecycleView.setLayoutManager(layoutManager);
        favRecycleView.setAdapter(favAdapter);
        repo.getStoredData().observe(FavProductsActivity.this, new Observer<List<Product>>() {
                    @Override
                    public void onChanged(List<Product> products) {
                        favAdapter.setList(products);
                        favAdapter.notifyDataSetChanged();
                    }
                }
        );
    }

    @Override
    public void onClick(Product product) {
        repo.delete(product);
        favAdapter.notifyDataSetChanged();
    }

}