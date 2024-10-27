package com.example.inkwell.services;

import org.springframework.stereotype.Service;
import com.example.inkwell.models.Category;

import java.util.List;
import java.util.ArrayList;

@Service
public class CategoryService {
    public List<Category> categories = new ArrayList<>(
            List.of(
                    new Category(1, "Fiction"),
                    new Category(2, "Technology"),
                    new Category(3, "History")));

    public List<Category> getCategories() {
        return categories;
    }
}
