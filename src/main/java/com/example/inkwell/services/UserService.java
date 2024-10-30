package com.example.inkwell.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inkwell.dto.UserDto;
import com.example.inkwell.entity.UserEntity;
import com.example.inkwell.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getUsers() {
        ModelMapper modelMapper = new ModelMapper();
        List<UserEntity> userEntities = userRepository.findAll();

        return modelMapper.map(userEntities, new TypeToken<List<UserDto>>() {
        }.getType());
    }
}