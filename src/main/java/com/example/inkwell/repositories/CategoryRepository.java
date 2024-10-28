package com.example.inkwell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inkwell.entity.*;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    // Add custom query methods if needed
}
