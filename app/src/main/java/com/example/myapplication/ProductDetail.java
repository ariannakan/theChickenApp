package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        TextView productName = findViewById(R.id.detail_productName);
        ImageView productImage = findViewById(R.id.detail_productImage);
        TextView productLink = findViewById(R.id.detail_productLink);

        productName.setText(getIntent().getStringExtra("name"));
        productImage.setImageResource(getIntent().getIntExtra("image_resource",0));
        productLink.setText(getIntent().getStringExtra("weblink"));

    }
}
