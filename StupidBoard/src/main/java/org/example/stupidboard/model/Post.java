package org.example.stupidboard.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="post_table")
@Builder(toBuilder = true)
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String writer;
    private LocalDateTime modifiedTime;

//    public static Post of(PostDTO dto){
//        return new Post(dto.getId(), dto.getTitle());
//    }
}
