package com.goorm.homework.bulletinboard.repository;

import com.goorm.homework.bulletinboard.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
