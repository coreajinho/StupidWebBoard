package org.example.stupidBoard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.stupidBoard.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    
}