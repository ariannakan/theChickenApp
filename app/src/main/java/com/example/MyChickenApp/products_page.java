package com.example.MyChickenApp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class products_page extends AppCompatActivity {

    private List<Product> productList;
    private RecyclerView rv;
    private ProductViewModel mProductViewModel;

    public static final int NEW_PRODUCT_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_page);

        rv = findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        final ProductListAdaptor pAdapter = new ProductListAdaptor(productList);
        rv.setAdapter(pAdapter);

        mProductViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        mProductViewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable final List<Product> products) {
                // Update the cached copy of the words in the adapter.
                pAdapter.setProducts(products);
            }
        });

        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText productName = findViewById(R.id.newProductInput);
                String name = productName.getText().toString();

                Intent addIntent = new Intent(products_page.this, AddProduct.class);
                addIntent.putExtra("new_product_name", name);
                startActivityForResult(addIntent, NEW_PRODUCT_ACTIVITY_REQUEST_CODE);
            }
        });

        //initializeData();
    }

    // this method creates an list that has three Product objects
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
        EditText productName = findViewById(R.id.newProductInput);
        String name = productName.getText().toString();


        Intent addIntent = new Intent(products_page.this, AddProduct.class);
        addIntent.putExtra("new_product_name", name);
        startActivityForResult(addIntent, NEW_PRODUCT_ACTIVITY_REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_PRODUCT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String pName = data.getStringExtra(AddProduct.EXTRA_REPLY_NAME);
            String pDesc = data.getStringExtra(AddProduct.EXTRA_REPLY_DESC);
            String pImage = data.getStringExtra(AddProduct.EXTRA_REPLY_IMAGE);
            String pMenu = data.getStringExtra(AddProduct.EXTRA_REPLY_MENU);
            mProductViewModel.insert(new Product(pName, pMenu, pDesc, pImage));
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}
