package testL9.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class PostInBlog {
    @Id
    private Integer id;
    private String title;
    private String content;
    @OneToMany
    private List<Tag> tags;

    public PostInBlog(Integer id, String title, String content, List<Tag> tags) {
        this.id=id;
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public PostInBlog(PostInBlog p){
        this.id=p.id;
        this.title = p.title;
        this.content = p.content;
        this.tags = p.tags;
    }

    public PostInBlog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Tag> getTag() {
        return tags;
    }

    public void setTag(List<Tag> tags) {
        this.tags = tags;
    }
}
