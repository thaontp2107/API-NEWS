package com.phuongthao.news_api.repository;

import com.phuongthao.news_api.entities.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<NewEntity, Long> {

}
