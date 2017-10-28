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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        if (!getId().equals(tag.getId())) return false;
        return getContent() != null ? getContent().equals(tag.getContent()) : tag.getContent() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }
}
