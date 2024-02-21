package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.repository.CommentJpaRepository;
import com.blog.vo.Comment;

@Service
public class CommentService {

    @Autowired
    CommentJpaRepository commentJpaRepository;

    public boolean saveComment(Comment comment) {
        Comment result = commentJpaRepository.save(comment);
        return result != null;
    }

    public List<Comment> getCommentList(Long postId) {
        return commentJpaRepository.findAllByPostIdOrderByRegDateDesc(postId);
    }

    public Comment getComment(Long id) {
        return commentJpaRepository.findById(id);
    }

    public boolean deleteComment(Long id) {
        Comment result = commentJpaRepository.findById(id);

        if (result == null)
            return false;

        commentJpaRepository.deleteById(id);
        return true;
    }

    public List<Comment> searchComments(Long postId, String query) {
        return commentJpaRepository.findAllByPostIdAndCommentContainingOrderByRegDateDesc(postId, query);
    }
}
