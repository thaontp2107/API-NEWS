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

    public List<CategoryEntity> getAllCategories (){
        return categoryRepository.findAll();
    }

    public CategoryEntity createCategory(CategoryEntity category){

        if(categoryRepository.existsByTenDanhMuc(category.getTenDanhMuc())){
            throw new RuntimeException("Category already exists");
        }
        return categoryRepository.save(category);
    }

    public CategoryEntity getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void deleteCategory(Long id){
        if(!categoryRepository.existsById(id)){
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(id);
    }

    public CategoryEntity updateCategory(Long id, CategoryEntity category) {
        CategoryEntity existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("category not found"));

        if(!existingCategory.getTenDanhMuc().equalsIgnoreCase(category.getTenDanhMuc())
            && categoryRepository.existsByTenDanhMuc(category.getTenDanhMuc())) {
            throw new RuntimeException("Category already exists");
        }
        existingCategory.setTenDanhMuc(category.getTenDanhMuc());
        existingCategory.setMoTa(category.getMoTa());

        return categoryRepository.save(existingCategory);
    }
}
