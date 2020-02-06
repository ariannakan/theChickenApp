package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class ProductRoomDatabase extends RoomDatabase {

    public abstract ProductDAO productDAO();

    private static ProductRoomDatabase INSTANCE;

    public static ProductRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProductRoomDatabase.class, "product_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    /**
     * Populate the database in the background.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final ProductDAO mDao;
        Product[] products = {
                new Product("Popeyes", "https://www.popeyes.com/explore-menu", "'Love that Chicken from Popeyes.' \n - Verified User", R.drawable.popeyes),
                new Product("KFC", "https://www.kfc.com/menu/chicken", "'Good job Dana. I will be back.' \n - Verified User", R.drawable.kfc),
                new Product("Chick-Fil-A", "https://www.chick-fil-a.com/","'GUYS GUESS WHAT THEY HAVE...MOUTHWASH, in their bathrooms.' \n - Verified User", R.drawable.chickfila),
                new Product("McDonald's", "https://www.mcdonalds.com/us/en-us/full-menu.html", "'When you go to McDonald's you basically have hit rock bottom. And it's amazing.' - Verified User" + "\r\n" +
                        "'Thank you for helping me maintain my weight' - Verified User", R.drawable.mcd) };

        PopulateDbAsync(ProductRoomDatabase db) {
            mDao = db.productDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
            mDao.deleteAll();

            for (int i = 0; i <= products.length - 1; i++) {
                Product p = products[i];
                mDao.insert(p);
            }
            return null;
        }
    }

}
