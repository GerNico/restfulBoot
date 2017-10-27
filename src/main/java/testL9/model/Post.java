package testL9.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Post {
    @Id
    private Integer id;
    private String title;
    private String content;
    @JsonProperty("tags")
    @OneToMany( cascade = CascadeType.ALL)
    private List<Tag> tags;

    public Post(Integer id, String title, String content, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public Post() {
    }

    public Post(Post p) {
        this.id = p.id;
        this.title = p.title;
        this.content = p.content;
        this.tags = p.tags;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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

}
