package com.example.MyChickenApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Displays Toast Message then go to Jokes page**/
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /** Shows a message that the Jokes image was clicked **/
    public void showJokes(View view){
        displayToast(getString(R.string.jokes_message));
        Intent jokesIntent = new Intent(this, joke_page.class);
        startActivity(jokesIntent);
    }

    /** Shows a message that the Products image was clicked **/
    public void showProducts(View view){
        displayToast(getString(R.string.products_message));
        Intent productsIntent = new Intent(this, products_page.class);
        startActivity(productsIntent);
    }

    /** Shows a message that the Recipes image was clicked **/
    public void showRecipes(View view){
        displayToast(getString(R.string.recipes_message));
        Intent recipesIntent = new Intent(this, recipes_page.class);
        startActivity(recipesIntent);
    }

    /** Called when the user taps the Why button **/
    public void viewPunchline(View view){
        Intent intent2 = new Intent(this, punchline.class);
        startActivity(intent2);
    }
}
