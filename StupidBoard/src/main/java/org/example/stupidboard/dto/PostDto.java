package org.example.stupidboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDateTime;

public class PostDto {
    public record Request(
            @Size(min=1, max=50) @NotBlank String title,
            @Size(min=1) @NotBlank String content,
            @Size(min=5, max = 15) @NotBlank String writer
    ){
    }
    @Builder
    public record Response(
            Long id,
            String title,
            String content,
            String writer,
            LocalDateTime createdTime,
            LocalDateTime modifiedTime
    ) {
    }
}
