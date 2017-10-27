package testL9.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testL9.model.Post;
import testL9.model.Tag;
import testL9.services.PostService;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getPosts() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        return new ResponseEntity<>(postService.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public ResponseEntity createPost(@RequestBody Post post) {
        postService.save(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public ResponseEntity updatePost(@PathVariable Integer id, @RequestBody Post post) {
        Post p = new Post(post);
        p.setId(id);
        postService.save(p);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePost(@PathVariable Integer id) {
        postService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //----

    @RequestMapping(value = "/posts/{id}/tags", method = RequestMethod.GET)
    public ResponseEntity<List<Tag>> getTagsOfPost(@PathVariable Integer id) {
        return new ResponseEntity<>(postService.get(id).getTags(), HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{id}/tags/{tagId}", method = RequestMethod.GET)
    public ResponseEntity getTeg(@PathVariable Integer id, @PathVariable Integer tagId) {
        Post post = postService.get(id);
        if (post != null && post.getTags().stream().map(Tag::getId).count() > 0)
            return new ResponseEntity<>(postService.get(id).getTags().get(tagId), HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/posts/{id}/tags/", method = RequestMethod.POST)
    public ResponseEntity insertTegToPost(@PathVariable Integer id, @RequestBody Tag tag) {
        Post p = postService.get(id);
        p.getTags().add(tag);
        postService.save(p);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{id}/tags/{tagId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTegFromPost(@PathVariable Integer id, @PathVariable Integer tagId) {
        Post p = postService.get(id);

        if (p.getTags().stream().map(Tag::getId).filter(item -> item.equals(tagId)).count() > 0) {
            p.getTags().removeIf(tag -> tag.getId().equals(tagId));
            postService.save(p);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
