package testL9.services;

import org.springframework.stereotype.Service;
import testL9.model.PostInBlog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostInBlog post1 = new PostInBlog(0, "zero", "fjfhkjdgfsgussf", null);
    private PostInBlog post2 = new PostInBlog(1, "one", "fjfa;fklv;ak;sf", null);
    private PostInBlog post3 = new PostInBlog(2, "two", "fjf;ak;sf", null);
    private List<PostInBlog> list = new ArrayList<>();

    {
        list.add(post1);
        list.add(post2);
        list.add(post3);
    }

    public List<PostInBlog> getAll() {
        return list;
    }

    public PostInBlog get(Integer id) {
        return list.stream().filter(item->item.getId().equals(id)).findAny().get();
    }

    public void put(PostInBlog postInBlog){
        if (!this.list.contains(postInBlog)) {list.add(postInBlog);
        }
    }

    public void update(PostInBlog postInBlog){
        list=list.stream()
                .filter(item->item.getId().equals(postInBlog.getId()))
                .peek(item->item=postInBlog)
                .collect(Collectors.toList());
    }

    public void delete(Integer id){
        list.removeIf(item->!item.getId().equals(id));
    }

}
