package com.example.myapplication;

public class Product {

    private final int imageResource;
    private String name;
    private String info;

    public Product(String name, String info, int imageResource){
        this.name = name;
        this.info = info;
        this.imageResource = imageResource;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getInfo(){
        return info;
    }

    public void setInfo() {
        this.info = info;
    }

    public int getImageResource(){
        return imageResource;
    }
}
