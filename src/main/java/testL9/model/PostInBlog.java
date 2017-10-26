package testL9.model;


import java.util.List;

public class PostInBlog {
    private Integer id;
    private String title;
    private String content;
    private List<String> tags;

    public PostInBlog(Integer id, String title, String content, List<String> tags) {
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "PostInBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostInBlog)) return false;

        PostInBlog that = (PostInBlog) o;

        if (!getId().equals(that.getId())) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        if (getContent() != null ? !getContent().equals(that.getContent()) : that.getContent() != null) return false;
        return getTags() != null ? getTags().equals(that.getTags()) : that.getTags() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        result = 31 * result + (getTags() != null ? getTags().hashCode() : 0);
        return result;
    }
}
