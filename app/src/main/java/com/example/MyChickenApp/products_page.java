package com.example.MyChickenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
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
        productList.add(new Product("Popeyes", "https://www.popeyes.com/explore-menu", "'Love that Chicken from Popeyes.' \n - Verified User", R.drawable.popeyes));
        productList.add(new Product("KFC", "https://www.kfc.com/menu/chicken", "'Good job Dana. I will be back.' \n - Verified User", R.drawable.kfc));
        productList.add(new Product("Chick-Fil-A", "https://www.chick-fil-a.com/","'GUYS GUESS WHAT THEY HAVE...MOUTHWASH, in their bathrooms.' \n - Verified User", R.drawable.chickfila));
        productList.add(new Product("McDonald's", "https://www.mcdonalds.com/us/en-us/full-menu.html", "'When you go to McDonald's you basically have hit rock bottom. And it's amazing.' - Verified User" + "\r\n" +
                "'Thank you for helping me maintain my weight' - Verified User", R.drawable.mcd));
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
        productList.add(new Product(name, "None","None", 0));
        // Notify the adapter, that the data has changed.
        rv.getAdapter().notifyItemInserted(pListSize);
        // Scroll to the bottom.
        rv.smoothScrollToPosition(pListSize);
    }

}
