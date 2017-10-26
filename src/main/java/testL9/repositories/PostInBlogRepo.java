package testL9.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testL9.model.PostInBlog;
import testL9.model.Tag;

import java.util.List;

@Repository
public interface PostInBlogRepo extends CrudRepository<PostInBlog,Integer>{

}
