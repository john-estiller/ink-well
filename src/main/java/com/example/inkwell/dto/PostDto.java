package com.example.inkwell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private int postId;
    private String title;
    private String content;
    private UserDto author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
