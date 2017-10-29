package testL9.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testL9.model.Post;
import testL9.repositories.BlogRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    BlogRepository blogRepository;

    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        blogRepository.findAll().forEach(posts::add);
        return posts;
    }

    public Post get(Integer id) {
        return blogRepository.findOne(id);
    }

    public void save(Post post) {
        blogRepository.save(post);
    }

    public void delete(Integer id) {
        blogRepository.delete(id);
    }

}
