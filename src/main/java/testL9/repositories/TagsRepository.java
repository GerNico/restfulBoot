package testL9.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testL9.model.Tag;

@Repository
public interface TagsRepository extends CrudRepository<Tag, Integer> {
}
