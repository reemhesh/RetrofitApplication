package com.example.retrofitapplication.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "price")
    private String price;

    @ColumnInfo(name = "brand")
    private String brand;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "rating")
    private float rating;

    @ColumnInfo(name = "thumbnail")
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public Product() {
    }
    @Ignore
    public Product(String title, String price, String brand, String description, float rating, String thumbnail) {
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.rating = rating;
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", thumbnail=" + thumbnail +
                '}';
    }
}



