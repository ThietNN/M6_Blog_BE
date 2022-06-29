package blog.m6_final_be.service.blog;

import blog.m6_final_be.model.Blog;
import blog.m6_final_be.service.IGeneralService;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findAllByUserId(Long id);
    void removeAllByUserId (Long id);
}
