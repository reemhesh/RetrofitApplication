package com.example.retrofitapplication.db;
import android.content.Context;
import androidx.lifecycle.LiveData;

import com.example.retrofitapplication.model.Product;
import com.example.retrofitapplication.network.API_Client;
import com.example.retrofitapplication.network.NetworkDelegate;

import java.util.List;

public class Repository implements NetworkDelegate {
    private Context context;
    private static Repository repository = null;
    private ProductDao productDao;
    private LiveData<List<Product>> storedProducts;
    private API_Client apiClient;

    public Repository(Context context) {
        this.context = context;
        AppDatabase db = AppDatabase.getInstance(context.getApplicationContext());
        productDao = db.productDao();
        storedProducts = productDao.getAllProducts();

        apiClient = API_Client.getInstance(this);
        apiClient.startCall();
    }

    public LiveData<List<Product>> getStoredData() {
        return storedProducts;
    }

    public void delete(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                productDao.deleteProduct(product);
            }
        }).start();
    }

    public void insert(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                productDao.insertProduct(product);
            }
        }).start();
    }



    @Override
    public void sucess(List<Product> products) {
        for (Product product : products) {
            insert(product);
        }
    }

    @Override
    public void failure(String errorMsg) {
        // Handle API call failure
    }

    public static Repository getInstance(Context context) {
        if (repository == null) {
            repository = new Repository(context);
        }
        return repository;
    }
}
