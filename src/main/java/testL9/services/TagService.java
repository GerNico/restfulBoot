package testL9.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testL9.model.Tag;
import testL9.repositories.TagsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    TagsRepository tagsRepository;

    public List<Tag> getAll() {
        List<Tag> tags = new ArrayList<>();
        tagsRepository.findAll().forEach(tags::add);
        return tags;
    }

    public Tag get(Integer id) {
        return tagsRepository.findOne(id);
    }

    public void save(Tag tag) {
        tagsRepository.save(tag);
    }

    public void delete(Integer id) {
        tagsRepository.delete(id);
    }

}
