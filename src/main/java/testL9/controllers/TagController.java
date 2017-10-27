package testL9.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testL9.model.Tag;
import testL9.services.TagService;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagService tagService;

    @RequestMapping(value = "/posts/tags", method = RequestMethod.GET)
    public ResponseEntity<List<Tag>> getTags() {
        return new ResponseEntity<>(tagService.getAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/tags/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tag> getTag(@PathVariable Integer id) {
        return new ResponseEntity<>(tagService.get(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/tags/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateTag(@PathVariable Integer id, @RequestBody Tag tag) {
        Tag p = new Tag(tag);
        p.setId(id);
        tagService.save(p);
        return new ResponseEntity(HttpStatus.OK);

    }
}