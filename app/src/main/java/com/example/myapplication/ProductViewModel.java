package com.example.myapplication;
import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepository mRepository;

    private LiveData<List<Product>> mAllProducts;

    public ProductViewModel (Application application){
        super(application);
        mRepository = new ProductRepository(application);
        mAllProducts = mRepository.getmAllProducts();
    }

    LiveData<List<Product>> getAllProducts() { return mAllProducts; }

    public void insert(Product product){ mRepository.insert(product); }


}
