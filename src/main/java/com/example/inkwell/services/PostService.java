package com.example.inkwell.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inkwell.dto.PostDto;
import com.example.inkwell.entity.PostEntity;
import com.example.inkwell.entity.UserEntity;
import com.example.inkwell.repositories.PostRepository;
import com.example.inkwell.controllers.dto.CreatePostReqDto;
import com.example.inkwell.exceptions.BadRequestException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<PostDto> getPosts() {
        ModelMapper modelMapper = new ModelMapper();
        List<PostEntity> postEntities = postRepository.findAll();

        return modelMapper.map(postEntities, new TypeToken<List<PostDto>>() {
        }.getType());
    }

    public void createPost(CreatePostReqDto createPostDto) {
        try {
            PostEntity postEntity = new PostEntity();
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(createPostDto.getAuthorId());

            postEntity.setAuthor(userEntity);
            postEntity.setTitle(createPostDto.getTitle());
            postEntity.setContent(createPostDto.getContent());

            postRepository.save(postEntity);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException error: " + e.getMessage());
            throw new BadRequestException("An illegal or inappropriate argument have passed.");
        } catch (Exception e) {
            System.out.println("Exception error: " + e.getMessage());
            throw new BadRequestException("An error occurred when during creation of post.");
        }

    }
}