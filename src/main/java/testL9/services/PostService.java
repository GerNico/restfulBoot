package testL9.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testL9.model.Post;
import testL9.repositories.BlogRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    BlogRepo blogRepo;

    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        blogRepo.findAll().forEach(posts::add);
        return posts;
    }

    public Post get(Integer id) {
        return blogRepo.findOne(id);
    }

    public void save(Post post) {
        blogRepo.save(post);
    }

    public void delete(Integer id) {
        blogRepo.delete(id);
    }

}
