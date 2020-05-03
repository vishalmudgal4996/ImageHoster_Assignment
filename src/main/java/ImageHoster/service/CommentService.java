package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Service
public class CommentService {

    @Autowired
    CommentRepository repository;

    public void createComment(Comment comment){
        repository.createComment(comment);
    }
}
