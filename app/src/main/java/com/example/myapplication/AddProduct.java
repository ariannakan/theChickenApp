package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddProduct extends AppCompatActivity {

    public static final String EXTRA_REPLY_NAME =
            "com.example.android.roomwordssample.REPLY";
    public static final String EXTRA_REPLY_DESC =
            "com.example.android.roomwordssample.DESC";
    public static final String EXTRA_REPLY_IMAGE =
            "com.example.android.roomwordssample.IMAGE";
    public static final String EXTRA_REPLY_MENU =
            "com.example.android.roomwordssample.MENU";


    private EditText mEditNameView;
    private EditText mEditDescView;
    private EditText mEditImageView;
    private EditText mEditMenuView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        mEditNameView = findViewById(R.id.name_text);
        mEditDescView = findViewById(R.id.desc_text);
        mEditImageView = findViewById(R.id.imageLink_text);
        mEditMenuView = findViewById(R.id.webMenu_text);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditNameView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String name = mEditNameView.getText().toString();
                    String desc = mEditDescView.getText().toString();
                    String image = mEditImageView.getText().toString();
                    String menu = mEditMenuView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY_NAME, name);
                    replyIntent.putExtra(EXTRA_REPLY_DESC, desc);
                    replyIntent.putExtra(EXTRA_REPLY_IMAGE, image);
                    replyIntent.putExtra(EXTRA_REPLY_MENU, menu);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }
}
