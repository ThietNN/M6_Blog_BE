package blog.m6_final_be.model;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Long id;
    private MultipartFile image;
    private String content;

    public BlogForm() {
    }

    public BlogForm(MultipartFile image, String content) {
        this.image = image;
        this.content = content;
    }

    public BlogForm(Long id, MultipartFile image, String content) {
        this.id = id;
        this.image = image;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

