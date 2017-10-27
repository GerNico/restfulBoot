package testL9.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testL9.model.Tag;
import testL9.repositories.TagsRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    TagsRepo tagsRepo;

    public List<Tag> getAll() {
        List<Tag> tags = new ArrayList<>();
        tagsRepo.findAll().forEach(tags::add);
        return tags;
    }

    public Tag get(Integer id) {
        return tagsRepo.findOne(id);
    }

    public void save(Tag tag) {
        tagsRepo.save(tag);
    }

    public void delete(Integer id) {
        tagsRepo.delete(id);
    }

}
