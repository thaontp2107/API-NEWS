package com.phuongthao.news_api.service;

import com.phuongthao.news_api.entities.UserEntity;
import com.phuongthao.news_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }

}
