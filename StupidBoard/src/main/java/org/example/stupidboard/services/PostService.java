package org.example.stupidboard.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.stupidboard.dto.PostDto;
import org.example.stupidboard.model.Post;
import org.example.stupidboard.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post toPostEntity(PostDto.Request postDto){
        return Post.builder()
                .title(postDto.title())
                .content(postDto.content())
                .writer(postDto.writer())
                .build();
    }

    public PostDto.Response toPostDto(Post post) {
        return PostDto.Response.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .writer(post.getWriter())
                .createdTime(post.getCreatedAt())
                .modifiedTime(post.getModifiedAt())
                .build();
    }

    public PostDto.Response createPost(PostDto.Request postDto) {
        Post post = this.toPostEntity(postDto);
        Post savedPost = postRepository.save(post);
        return this.toPostDto(savedPost);
    }


    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }
}