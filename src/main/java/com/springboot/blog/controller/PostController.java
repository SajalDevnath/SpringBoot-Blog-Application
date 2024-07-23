package com.springboot.blog.controller;

import com.springboot.blog.entity.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts") // - This is the BASE URL for the REST APIs
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post rest api
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<PostDto>(postService.createPost(postDto) , HttpStatus.CREATED);
    }

    // get all blog post rest api
    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

}

