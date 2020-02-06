package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface ProductDAO {

    @Insert
    void insert(Product name);

    @Query("DELETE FROM productTable")
    void deleteAll();

    @Query("SELECT * from productTable ORDER BY product ASC")
    LiveData<List<Product>> getAllProducts();
}
