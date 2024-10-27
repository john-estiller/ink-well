package com.example.inkwell.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inkwell.models.Category;
import com.example.inkwell.repositories.CategoryRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> categories = new ArrayList<>(
            List.of(
                    new Category(1, "Fiction"),
                    new Category(2, "Technology"),
                    new Category(3, "History")));

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        return null;
    }
}
