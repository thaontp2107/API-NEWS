package com.phuongthao.news_api.controller;

import com.phuongthao.news_api.entities.NewEntity;
import com.phuongthao.news_api.service.NewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class Newcontroller {

    private final NewService newService;

    public Newcontroller(NewService newService) {
        this.newService = newService;
    }

    @GetMapping
    public List<NewEntity> getAllNews(){
        return newService.getAllNews();
    }

    @GetMapping("/{id}")
    public NewEntity getNewById(@PathVariable Long id){
        return newService.getNewById(id);
    }

    @PostMapping
    public NewEntity createNew(@RequestBody NewEntity newEntity){
        return newService.createNew(newEntity);
    }

    @PutMapping
    public NewEntity updateNew(@PathVariable Long id, @RequestBody NewEntity newEntity){
        return newService.updateNew(id, newEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteNew(@PathVariable Long id){
        newService.deleteNewById(id);
    }

}
