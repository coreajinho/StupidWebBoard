package org.example.stupidboard.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class PostDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String writer;
    private final LocalDateTime modifiedTime;


}
