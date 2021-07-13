package com.cheerup.cheerup.repository;

import com.cheerup.cheerup.model.CommentLikeIt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentLikeItRepository extends JpaRepository<CommentLikeIt, Long> {
    Optional<List<CommentLikeIt>> findAllByCommentId(Long commentId);
    Long countByCommentId(Long articleId);
    void deleteByUsernameAndCommentId(String username, Long commentId);
    CommentLikeIt findByUsernameAndCommentId(String username, Long commentId);
}