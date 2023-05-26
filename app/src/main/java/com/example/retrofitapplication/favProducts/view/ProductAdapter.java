package com.example.retrofitapplication.favProducts.view;


import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitapplication.R;
import com.example.retrofitapplication.model.Product;

import java.util.List;
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private List<Product> products;
    private static  final String TAG = "recyclerView";
    private onFavouriteClickListener listner;
    Product product;


    public ProductAdapter(Context context , List<Product> products,onFavouriteClickListener listner){
        this.context = context;
        this.products = products;
        this.listner=listner;
    }
   public  void setList(List<Product> updateProducts){
        this.products=updateProducts;
   }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.item_product2, recyclerView , false);
        ViewHolder vh = new ViewHolder(v);
        Log.i(TAG, "onCreateViewHolder: ");
        return vh;

    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.TitleText.setText(products.get(position).getTitle());
        holder.PriceText.setText(products.get(position).getPrice());
        holder.BrandText.setText(products.get(position).getBrand());

        holder.DescriptionText.setText(products.get(position).getDescription());
        Glide.with(context).load(products.get(position).getThumbnail()).placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground).into(holder.photo);
       holder.favBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               listner.onClick(product);
           }
       });
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,products.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        Log.i(TAG, "onBindViewHolder: ");

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView TitleText;
        public  TextView PriceText;
        public TextView BrandText;
        public  TextView DescriptionText;
        public RatingBar Rating;
        public  ImageView photo;
        public ConstraintLayout constraintLayout;
        public View layout;
        public Button favBtn;

        public  ViewHolder(View v){
            super(v);
            layout = v;
            TitleText = v.findViewById(R.id.titleTextView);
            PriceText = v.findViewById(R.id.priceTextView);
            BrandText = v.findViewById(R.id.brandTextView);
            DescriptionText = v.findViewById(R.id.descriptionTextView);
            photo = v.findViewById(R.id.thumbnailImageView);
            constraintLayout = v.findViewById(R.id.row);
           favBtn=v.findViewById(R.id.favBtn);

        }


    }
}


