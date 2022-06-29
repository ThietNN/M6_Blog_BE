package blog.m6_final_be.model;

import javax.persistence.*;

@Entity
@Table (name = "blogs")
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private String content;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public Blog() {

    }


    public Blog(String title, String image, String content, User user) {
        this.title = title;
        this.image = image;
        this.content = content;
        this.user = user;
    }

    public Blog(Long id, String title, String image, String content, User user) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
