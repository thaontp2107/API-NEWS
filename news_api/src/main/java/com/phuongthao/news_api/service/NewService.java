
package com.phuongthao.news_api.service;

import com.phuongthao.news_api.entities.CategoryEntity;
import com.phuongthao.news_api.entities.NewEntity;
import com.phuongthao.news_api.entities.NewsStatus;
import com.phuongthao.news_api.entities.UserEntity;

import com.phuongthao.news_api.repository.NewRepository;
import com.phuongthao.news_api.repository.CategoryRepository;
import com.phuongthao.news_api.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewService {

    private final NewRepository newRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public NewService(NewRepository newRepository,
                      CategoryRepository categoryRepository,
                      UserRepository userRepository) {

        this.newRepository = newRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }


    public List<NewEntity> getAllNews() {
        return newRepository.findAll();
    }


    public NewEntity getNewById(Long id) {
        return newRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("New not found"));
    }

    public NewEntity createNew(NewEntity newEntity) {

        if(newEntity == null) {
            throw new RuntimeException("News cannot be empty");
        }

        if(newEntity.getTieuDe() == null ||
                newEntity.getTieuDe().isBlank()) {
            throw new RuntimeException("Title cannot be empty");
        }

        if(newEntity.getNoiDung() == null ||
                newEntity.getNoiDung().isBlank()) {
            throw new RuntimeException("Content cannot be empty");
        }


        if(newEntity.getCategory() == null ||
                newEntity.getCategory().getId() == null) {
            throw new RuntimeException("Category cannot be empty");
        }

        CategoryEntity category = categoryRepository.findById(
                        newEntity.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));


        if(newEntity.getUser() == null ||
                newEntity.getUser().getId() == null) {
            throw new RuntimeException("User cannot be empty");
        }

        UserEntity user = userRepository.findById(
                        newEntity.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        newEntity.setCategory(category);
        newEntity.setUser(user);


        newEntity.setTrangThai(NewsStatus.valueOf("PENDING"));
        newEntity.setLuotXem(0L);
        newEntity.setNgayDang(LocalDateTime.now());
        newEntity.setNgayCapNhat(LocalDateTime.now());

        return newRepository.save(newEntity);
    }


    public void deleteNewById(Long id) {

        if(!newRepository.existsById(id)) {
            throw new RuntimeException("New not found");
        }

        newRepository.deleteById(id);
    }


    public NewEntity updateNew(Long id, NewEntity newEntity) {

        if(newEntity == null) {
            throw new RuntimeException("News cannot be empty");
        }

        NewEntity existingNew = newRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("New not found"));


        if(newEntity.getTieuDe() == null ||
                newEntity.getTieuDe().isBlank()) {
            throw new RuntimeException("Title cannot be empty");
        }

        if(newEntity.getNoiDung() == null ||
                newEntity.getNoiDung().isBlank()) {
            throw new RuntimeException("Content cannot be empty");
        }

        if(newEntity.getCategory() == null ||
                newEntity.getCategory().getId() == null) {
            throw new RuntimeException("Category cannot be empty");
        }

        CategoryEntity category = categoryRepository.findById(
                        newEntity.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existingNew.setTieuDe(newEntity.getTieuDe());
        existingNew.setNoiDung(newEntity.getNoiDung());
        existingNew.setHinhAnh(newEntity.getHinhAnh());
        existingNew.setNguonTin(newEntity.getNguonTin());
        existingNew.setCategory(category);
        existingNew.setNgayCapNhat(LocalDateTime.now());

        return newRepository.save(existingNew);
    }
}
