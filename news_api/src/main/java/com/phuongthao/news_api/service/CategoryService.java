package com.phuongthao.news_api.service;

import com.phuongthao.news_api.entities.CategoryEntity;
import com.phuongthao.news_api.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> gettAllCategories (){
        return categoryRepository.findAll();
    }

    public CategoryEntity createCategory(CategoryEntity category){
        return categoryRepository.save(category);
    }

}
