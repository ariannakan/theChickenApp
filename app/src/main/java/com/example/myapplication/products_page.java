package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class products_page extends AppCompatActivity {

    private ArrayList<Product> productList;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_page);

        rv = findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    // this method creates an Arraylist that has three Product objects
    private void initializeData(){
        productList = new ArrayList<>();
        productList.add(new Product("Popeyes", "Popeyes.com", R.drawable.popeyes));
        productList.add(new Product("KFC", "KFC.com", R.drawable.kfc));
        productList.add(new Product("Chick-Fil-A", "Chick-fil-a.com", R.drawable.chickfila));
        productList.add(new Product("McDonald's", "McDonalds.com", R.drawable.mcd));
    }

    private void initializeAdapter(){
        ProductListAdaptor pAdapter = new ProductListAdaptor(productList);
        rv.setAdapter(pAdapter);
    }

    public void addProduct(View view) {
        int pListSize = productList.size();

        EditText productName = findViewById(R.id.newProductInput);
        String name = productName.getText().toString();

        // Add a new product to the list.
        productList.add(new Product(name, "None", 0));
        // Notify the adapter, that the data has changed.
        rv.getAdapter().notifyItemInserted(pListSize);
        // Scroll to the bottom.
        rv.smoothScrollToPosition(pListSize);
    }

}
