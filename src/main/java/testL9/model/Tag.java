package testL9.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag {

    @Id
    private Integer id;
    private String content;


    public Tag(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Tag(Tag t) {
        this.id = t.id;
        this.content = t.content;
    }

    public Tag() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
