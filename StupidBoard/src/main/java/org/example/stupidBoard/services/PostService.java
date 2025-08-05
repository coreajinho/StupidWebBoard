package org.example.stupidBoard.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.stupidBoard.dto.PostDto;
import org.example.stupidBoard.exception.PostNotFoundExeption;
import org.example.stupidBoard.model.Post;
import org.example.stupidBoard.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post toPostEntity(PostDto.Request postDto) {
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
        Post post = toPostEntity(postDto);
        Post savedPost = postRepository.save(post);
        return toPostDto(savedPost);
    }

    public PostDto.Response updatePost(PostDto.Request postDto, Long id){
        Optional<Post> post = postRepository.findById(id);
        Post exeistPost = post.orElseThrow();
        exeistPost.setTitle(postDto.title());
        exeistPost.setContent(postDto.content());
        exeistPost.setWriter(postDto.writer());
        Post savedPost = postRepository.save(exeistPost);
        return toPostDto(savedPost);
    }

    public void deletePost(Long id){
            postRepository.deleteById(id);
    }

    public PostDto.Response getPost(Long id) throws Exception{
        Post post = postRepository.findById(id)
                .orElseThrow( () -> new PostNotFoundExeption("해당id의 게시글이 없습니다. "));
        return toPostDto(post);
    }
}