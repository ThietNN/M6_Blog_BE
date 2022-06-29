package blog.m6_final_be.repository;

import blog.m6_final_be.model.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends CrudRepository<Blog, Long> {
}
