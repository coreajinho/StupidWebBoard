package org.example.stupidboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.stupidboard.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    
}