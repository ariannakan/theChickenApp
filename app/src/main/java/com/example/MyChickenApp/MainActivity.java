package com.example.MyChickenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";

    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.activity_main_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case R.id.action_logout:
                FirebaseAuth.getInstance().signOut();
                Intent loginIntent = new Intent(MainActivity.this, User_Login.class);
                startActivity(loginIntent);
        }

        return super.onOptionsItemSelected(item);
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
