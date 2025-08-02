package org.example.stupidboard.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.stupidboard.dto.PostDto;
import org.example.stupidboard.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class Postcontroller {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto.Response> createPost(@Valid @RequestBody PostDto.Request postDto){
        PostDto.Response responseDto = postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @PutMapping("/{id}")
    public void updatePost(@Valid @RequestBody PostDto.Request postDto, @PathVariable Long id){

    }
}