package com.phuongthao.news_api.repository;

import com.phuongthao.news_api.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    boolean existsByTenDanhMuc(String tenDanhMuc);
}
