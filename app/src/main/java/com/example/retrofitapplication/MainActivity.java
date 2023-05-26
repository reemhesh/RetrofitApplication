package com.example.retrofitapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrofitapplication.allProducts.controller.AllProductsActivity;
import com.example.retrofitapplication.db.Repository;
import com.example.retrofitapplication.favProducts.controller.FavProductsActivity;
import com.example.retrofitapplication.model.Product;
import com.example.retrofitapplication.network.API_Client;
import com.example.retrofitapplication.network.NetworkDelegate;
import com.example.retrofitapplication.favProducts.view.ProductAdapter;
import com.example.retrofitapplication.favProducts.view.onFavouriteClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
      Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1= findViewById(R.id.getAll);
        btn2= findViewById(R.id.getFav);
        btn3= findViewById(R.id.exit);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to switch to another activity
                Intent intent = new Intent(MainActivity.this, AllProductsActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to switch to another activity
                Intent intent = new Intent(MainActivity.this, FavProductsActivity.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
