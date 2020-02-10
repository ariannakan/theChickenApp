package com.example.MyChickenApp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetail extends AppCompatActivity {

    private TextView productName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productName = findViewById(R.id.detail_productName);
        ImageView productImage = findViewById(R.id.detail_productImage);
        TextView productDesc = findViewById(R.id.detail_productDesc);
        WebView productMenu = findViewById(R.id.detail_webview_menu);

        productName.setText(getIntent().getStringExtra("name"));
        productImage.setImageResource(getIntent().getIntExtra("image_resource",0));
        productDesc.setText(getIntent().getStringExtra("desc"));

        WebSettings webSettings = productMenu.getSettings();
        webSettings.setJavaScriptEnabled(true);

        productMenu.loadUrl(getIntent().getStringExtra("menu"));
    }

    /** Shows a message that the Products image was clicked **/
    public void viewMap(View view){
        Intent mapIntent = new Intent(this, MapsActivity.class);
        mapIntent.putExtra("name", productName.toString());
        startActivity(mapIntent);
    }

}
