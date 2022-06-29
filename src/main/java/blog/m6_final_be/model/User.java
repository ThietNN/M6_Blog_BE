package blog.m6_final_be.model;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean admin = false;

    public User() {
    }

    public User(String name, boolean admin) {
        this.name = name;
        this.admin = admin;
    }

    public User(Long id, String name, boolean admin) {
        this.id = id;
        this.name = name;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
