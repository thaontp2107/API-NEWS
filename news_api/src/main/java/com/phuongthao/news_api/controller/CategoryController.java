package com.phuongthao.news_api.controller;

import com.phuongthao.news_api.entities.CategoryEntity;
import com.phuongthao.news_api.entities.UserEntity;
import com.phuongthao.news_api.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryEntity> getAllCategories(){

        return categoryService.getAllCategories();
    }

    @PostMapping
    public CategoryEntity createCategory(@RequestBody CategoryEntity category){
        return categoryService.createCategory(category);
    }
}
