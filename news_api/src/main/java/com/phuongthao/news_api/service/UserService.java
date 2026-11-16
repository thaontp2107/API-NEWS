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

    public UserEntity getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    public UserEntity updateUser(Long id, UserEntity user) {

        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(user.getName());
        existingUser.setGioiTinh(user.getGioiTinh());
        existingUser.setSdt(user.getSdt());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());

        return userRepository.save(existingUser);
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }

}
