package org.example.stupidBoard.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.stupidBoard.dto.PostDto;
import org.example.stupidBoard.services.PostService;
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
    public ResponseEntity<PostDto.Response> updatePost(@Valid @RequestBody PostDto.Request postDto, @PathVariable Long id){
        PostDto.Response responseDto = postService.updatePost(postDto,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto.Response> getPost(@PathVariable Long id) throws Exception{
        PostDto.Response responseDto = postService.getPost(id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(responseDto);
    }
}