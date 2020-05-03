package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/image/{id}/{title}/comments",method = RequestMethod.POST)
    public String createComment(@PathVariable("id") Integer id, @RequestParam(value = "comment")String comment, HttpSession session){

        User user=(User)session.getAttribute("loggeduser");
//        Image image=imageService.getImageByTitle(title,id);
        Image image=imageService.getImage(id);
        Comment newComment=new Comment();
        newComment.setUser(user);
        newComment.setImage(image);
        newComment.setCreatedDate(new Date());
        newComment.setText(comment);

        commentService.createComment(newComment);

        return "redirect:/images/" + image.getId() + "/" + image.getTitle();

    }
}
