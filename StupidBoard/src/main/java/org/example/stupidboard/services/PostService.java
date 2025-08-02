package org.example.stupidboard.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.stupidboard.model.Post;
import org.example.stupidboard.repositories.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.example.stupidboard.dto.PostDto;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @PostMapping
    public void createPost(PostDto postDto){
        Post post = new Post(postDto.)
        postRepository.save(postDto);
    }

    public Optional<Post> getPost(Long id){
        return postRepository.findById(id);
    }

//    public Post updatePost(Long id) {
//        Optional<Post> testPost = postRepository.findById(id);
//        if (!testPost.isPresent()) {
//            throw new NullPointerException("there is no TestPost");
//        }
//        Post updatePost = testPost.get();
//        updatePost = updatePost.toBuilder().content("updated").build();
//        log.info(updatePost.toString());
//        return postRepository.save(updatePost);
//    }
}
