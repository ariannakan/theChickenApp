package com.example.MyChickenApp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepository {

    private ProductDAO mProductDAO;
    private LiveData<List<Product>> mAllProducts;

    ProductRepository(Application application){
        ProductRoomDatabase db = ProductRoomDatabase.getDatabase(application);
        mProductDAO = db.productDAO();
        mAllProducts = mProductDAO.getAllProducts();
    }

    LiveData<List<Product>> getmAllProducts(){
        return mAllProducts;
    }

    public void insert(Product product){
        new insertAsyncTask(mProductDAO).execute(product);
    }

    private static class insertAsyncTask extends AsyncTask<Product, Void, Void> {

        private ProductDAO mAsyncTaskDao;

        insertAsyncTask(ProductDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Product... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
