package com.goorm.homework.bulletinboard.dto;


import com.goorm.homework.bulletinboard.domain.Post;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentDto {
    private Long id;

//    @NotNull(message = "게시물 값 비어있음")
//    private Post post;

    @NotNull(message = "내용 값 비어있음")
    private String content;
}
