package com.example.inkwell.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostReqDto {
    private String title;
    private String content;
    private int authorId;
}
