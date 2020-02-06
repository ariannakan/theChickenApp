package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "productTable")
public class Product {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "product")

    private int imageResource;
    private String webImage;
    private String name;
    private String desc;
    private String menu;

    public Product(@NonNull String name, String menu, String desc, int imageResource){
        this.name = name;
        this.menu = menu;
        this.desc = desc;
        this.imageResource = imageResource;
    }

    public Product(@NonNull String name, String menu, String desc, String imageResource){
        this.name = name;
        this.menu = menu;
        this.desc = desc;
        this.webImage = imageResource;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getMenu(){ return menu; }

    public void setMenu(String menu){
        this.menu = menu;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc() { this.desc = desc; }

    public int getImageResource(){
        return imageResource;
    }

    public void setImageResource(int image){
        this.imageResource = image;
    }

    public String getWebImage(){
        return webImage;
    }

    public void setWebImage(String image){
        this.webImage = image;
    }
}
