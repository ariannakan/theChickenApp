package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class joke_page extends AppCompatActivity {

    private EditText mWebsiteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_page);
        mWebsiteEditText = findViewById(R.id.website_editText);
    }


    public void openWebsite(View view) {
        //String url = mWebsiteEditText.getText().toString();
        Uri webPage = Uri.parse("http://www.google.com/search?q=chicken+jokes&oq=chicken+jokes&aqs=chrome.0.69i59l2j0l3j69i60l3.1534j0j4&sourceid=chrome&ie=UTF-8");
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }
}
