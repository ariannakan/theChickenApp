package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class products_page extends AppCompatActivity {

    private final LinkedList<String> productList = new LinkedList<>();
    private RecyclerView pRecyclerView;
    private ProductListAdaptor pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_page);
        productList.addLast("Popeyes");
        productList.addLast("KFC");
        productList.addLast("Chick-Fil-A");

        // Get a handle to the RecyclerView.
        pRecyclerView = findViewById(R.id.recyclerView);

        // Create an adapter and supply the data to be displayed.
        pAdapter = new ProductListAdaptor(this, productList);

        // Connect the adapter with the RecyclerView.
        pRecyclerView.setAdapter(pAdapter);

        // Give the RecyclerView a default layout manager.
        pRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addProduct(View view) {
        int pListSize = productList.size();

        EditText productName = findViewById(R.id.newProductInput);
        String product = productName.getText().toString();

        // Add a new word to the wordList.
        productList.addLast(product);
        // Notify the adapter, that the data has changed.
        pRecyclerView.getAdapter().notifyItemInserted(pListSize);
        // Scroll to the bottom.
        pRecyclerView.smoothScrollToPosition(pListSize);
    }

}
