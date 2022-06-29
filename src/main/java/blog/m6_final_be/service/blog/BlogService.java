package blog.m6_final_be.service.blog;

import blog.m6_final_be.model.Blog;
import blog.m6_final_be.repository.IBlogRepository;
import blog.m6_final_be.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Iterable<Blog> findAllByUserId(Long id) {
        List<Blog> blogs = (List<Blog>) blogRepository.findAll();
        List<Blog> blogList = new ArrayList<>();
        for (Blog blog: blogs) {
            if (blog.getUser().getId() == id) {
                blogList.add(blog);
            }
        }
        return blogList;
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        blogRepository.deleteAll();
    }

    @Override
    public void removeAllByUserId(Long id){
        List<Blog> blogs = (List<Blog>) findAllByUserId(id);
        blogRepository.deleteAll(blogs);
    }
}
