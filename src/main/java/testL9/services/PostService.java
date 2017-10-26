package testL9.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testL9.model.PostInBlog;
import testL9.model.Tag;
import testL9.repositories.PostInBlogRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostInBlogRepo postInBlogRepo;

    public List<PostInBlog> getAll() {
        List<PostInBlog> posts = new ArrayList<>();
        postInBlogRepo.findAll().forEach(posts::add);
        return posts;
    }

    public PostInBlog get(Integer id) {
        return postInBlogRepo.findOne(id);
    }

    public void put(PostInBlog postInBlog) {
        postInBlogRepo.save(postInBlog);
    }

    public void update(PostInBlog postInBlog) {
        postInBlogRepo.save(postInBlog);
    }

    public void delete(Integer id) {
        postInBlogRepo.delete(id);
    }

}
