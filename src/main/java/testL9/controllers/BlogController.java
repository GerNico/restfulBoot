package testL9.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testL9.model.PostInBlog;
import testL9.services.PostService;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<PostInBlog> getPosts() {
        return postService.getAll();
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public PostInBlog getPost(@PathVariable Integer id) {
        return postService.get(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public void createPost(@RequestBody PostInBlog postInBlog) {
        postService.put(postInBlog);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@PathVariable Integer id, @RequestBody PostInBlog postInBlog) {
        PostInBlog p = new PostInBlog(postInBlog);
        p.setId(id);
        postService.update(p);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Integer id) {
        postService.delete(id);
    }
}
