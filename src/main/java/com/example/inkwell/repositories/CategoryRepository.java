package com.example.inkwell.repositories;

import com.example.inkwell.models.Category; // Replace with your entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Add custom query methods if needed
}