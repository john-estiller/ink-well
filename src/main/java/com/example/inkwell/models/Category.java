package com.example.inkwell.models;

public class Category {
    private int category_id;
    private String name;

    public Category() {
    }

    public Category(int category_id, String name) {
        this.name = name;
        this.category_id = category_id;
    }

    public int getId() {
        return this.category_id;
    }

    public void setId(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
