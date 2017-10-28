package testL9.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {
    @Id
    private Integer id;
    private String title;
    private String content;
    @JsonProperty("tags")
    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (!getId().equals(post.getId())) return false;
        if (getTitle() != null ? !getTitle().equals(post.getTitle()) : post.getTitle() != null) return false;
        if(!(getContent() != null ? getContent().equals(post.getContent()) : post.getContent() == null))return false;
        if (this.tags.size()!=post.tags.size())return false;
        for (int i = 0; i < this.tags.size(); i++) {
            if (!this.tags.get(i).equals(post.tags.get(i)))return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }
}
