package com.goorm.homework.bulletinboard.controller;


import com.goorm.homework.bulletinboard.dto.ApiResponse;
import com.goorm.homework.bulletinboard.dto.PostDto;
import com.goorm.homework.bulletinboard.service.CommentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PatchMapping("/{postId}")
    public ResponseEntity<?> softDeleteComment(@PathVariable Long postId) {

        return ResponseEntity.ok().build();

    }

    @PostMapping("/create")
    public ResponseEntity<?> createComment(@RequestBody @Validated PostDto postRequest){
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<?> updateComment(@PathVariable Long postId, @RequestBody PostDto updatedPostDto) {

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update/{postId}")
    public ResponseEntity<?> updateComment(@PathVariable Long postId, @RequestBody Map<String, Object> updatedFields) {

        return ResponseEntity.ok().build();
    }
}
