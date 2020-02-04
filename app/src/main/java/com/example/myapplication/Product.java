package com.example.myapplication;

public class Product {

    private int imageResource;
    private String name;
    private String desc;
    private String menu;

    public Product(String name, String menu, String desc, int imageResource){
        this.name = name;
        this.menu = menu;
        this.desc = desc;
        this.imageResource = imageResource;
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
}
