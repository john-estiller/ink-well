package com.example.inkwell.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
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
        return ResponseUtil.response(true, categories);
    }

}