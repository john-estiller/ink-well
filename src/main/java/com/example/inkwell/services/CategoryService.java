package com.example.inkwell.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inkwell.dto.CategoryDto;
import com.example.inkwell.entity.CategoryEntity;
import com.example.inkwell.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> categories = new ArrayList<>(
            List.of(
                    new CategoryDto(1, "Fiction"),
                    new CategoryDto(2, "Technology"),
                    new CategoryDto(3, "History")));

    public List<CategoryDto> getCategories() {
        ModelMapper modelMapper = new ModelMapper();
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        return modelMapper.map(categoryEntities, new TypeToken<List<CategoryDto>>() {
        }.getType());
    }

    public CategoryDto getCategory(int id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return modelMapper.map(category.get(), CategoryDto.class);
        }
        return null;
    }
}
