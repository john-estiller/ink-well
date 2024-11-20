package com.example.inkwell.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inkwell.controllers.dto.CreatePostReqDto;
import com.example.inkwell.dto.PostDto;
import com.example.inkwell.services.PostService;
import com.example.inkwell.utils.ResponseUtil;
// import com.example.inkwell.;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    public PostService postService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getPosts() {
        List<PostDto> users = this.postService.getPosts();
        System.out.println("Posts: " + users);
        return ResponseUtil.response(true, users);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createPost(@RequestBody CreatePostReqDto createPostReqDto) {
        System.out.println("createPostReqDto: " + createPostReqDto);
        this.postService.createPost(createPostReqDto);
        return ResponseUtil.response(true, "Post Created!");
    }
}