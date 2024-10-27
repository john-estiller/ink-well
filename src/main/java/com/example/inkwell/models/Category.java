package com.example.inkwell.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Category") // Optional: Specify table name if different from class name
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id") // Optional: Specify column name
    private int categoryId;

    @Column(name = "name", nullable = false) // Optional: Specify column name and constraints
    private String name;

    // Constructors, Getters, and Setters

    public Category() {
        // Default constructor
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
