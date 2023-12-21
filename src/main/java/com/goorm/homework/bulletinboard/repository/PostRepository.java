package com.goorm.homework.bulletinboard.repository;

import com.goorm.homework.bulletinboard.domain.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findBySoftDeletedIsFalse(Sort sort);

    Optional<Post> findByIdAndSoftDeletedIsFalse(Long postId);

}
