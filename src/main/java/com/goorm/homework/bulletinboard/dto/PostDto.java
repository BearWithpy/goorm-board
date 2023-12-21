package com.goorm.homework.bulletinboard.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class PostDto {
    private Long id;

    @NotNull(message = "제목 값 비어있음")
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "내용 값 비어있음")
    private String content;

//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private Boolean isDeleted;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CommentDto> commentDtos;
}
