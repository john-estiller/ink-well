package com.example.inkwell.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Category") // Optional: Specify table name if different from class name
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id") // Optional: Specify column name
    private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "name", nullable = false) // Optional: Specify column name and constraints
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
