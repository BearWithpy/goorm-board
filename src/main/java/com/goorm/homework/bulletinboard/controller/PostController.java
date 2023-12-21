package com.goorm.homework.bulletinboard.controller;

import com.goorm.homework.bulletinboard.dto.ApiResponse;
import com.goorm.homework.bulletinboard.dto.PostDto;
import com.goorm.homework.bulletinboard.exception.PostNotFoundException;
import com.goorm.homework.bulletinboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<?> showAllPosts(){
        List<PostDto> posts = postService.findAllPost();

        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> showPost(@PathVariable Long postId) {
        PostDto postById = postService.findPostById(postId);

        return ResponseEntity.status(HttpStatus.OK).body(postById);

    }

    @PatchMapping("/{postId}")
    public ResponseEntity<?> softDeletePost(@PathVariable Long postId) {
        postService.softDeletePost(postId);

        ApiResponse response = new ApiResponse(HttpStatus.NO_CONTENT.value(), "Post deleted with ID: " + postId);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody @Validated PostDto postRequest){
        Long postId = postService.createPost(postRequest);

        ApiResponse response = new ApiResponse(HttpStatus.CREATED.value(), "Post created with ID: " + postId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable Long postId, @RequestBody PostDto updatedPostDto) {
        postService.updatePost(postId, updatedPostDto);

        ApiResponse response = new ApiResponse(HttpStatus.CREATED.value(), "Post updated with ID: "  + postId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/update/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable Long postId, @RequestBody Map<String, Object> updatedFields) {

        return ResponseEntity.ok().build();
    }
}
