package com.example.inkwell.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inkwell.services.CategoryService;
import com.example.inkwell.models.Category;
import com.example.inkwell.utils.ResponseUtil;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getCategories() {
        List<Category> categories = this.categoryService.getCategories();
        System.out.println("Categories " + categories);
        return ResponseUtil.response(true, categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCategory(@PathVariable int id) {
        Category category = this.categoryService.getCategory(id);
        System.out.println("Category " + category);
        return ResponseUtil.response(true, category);
    }
}