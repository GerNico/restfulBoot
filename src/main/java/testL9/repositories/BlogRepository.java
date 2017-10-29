package testL9.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testL9.model.Post;

@Repository
public interface BlogRepository extends CrudRepository<Post, Integer> {

}
