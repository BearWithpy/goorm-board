package com.goorm.homework.bulletinboard.service;


import com.goorm.homework.bulletinboard.domain.Comment;
import com.goorm.homework.bulletinboard.domain.Post;
import com.goorm.homework.bulletinboard.dto.CommentDto;
import com.goorm.homework.bulletinboard.repository.CommentRepository;
import com.goorm.homework.bulletinboard.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public Long createComment(Long id, CommentDto dto) {
        Post post = postRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));
        Comment comment = Comment.builder()
                .content(dto.getContent())
                .post(post)
                .build();

        return  commentRepository.save(comment).getId();
    }




}
