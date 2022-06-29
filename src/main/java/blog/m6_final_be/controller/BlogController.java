package blog.m6_final_be.controller;

import blog.m6_final_be.model.Blog;
import blog.m6_final_be.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    Environment environment;

    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> getAllBlog(){
        Iterable<Blog> blogs = blogService.findAll();
//        List<Blog> blogList= (List<Blog>) blogs;
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Iterable<Blog>> findAllBlogByUserId(@PathVariable Long id) {
        Iterable<Blog> blogs = blogService.findAllByUserId(id);
//        List<Blog> blogList= (List<Blog>) blogs;
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public ResponseEntity<Blog> saveBlog(@RequestBody BlogForm blogForm){
//        MultipartFile multipartFile = blogForm.getImage();
//        String fileName = multipartFile.getOriginalFilename();
//        String fileUpload = environment.getProperty("upload.path");
//        try {
//            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Blog blog = new Blog(fileName,blogForm.getContent());
//        blogService.save(blog);
//        return new ResponseEntity<>(blog, HttpStatus.CREATED);
//    }
    @PostMapping("/create")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updateBlog (@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> blog1 = blogService.findById(id);
        if (!blog1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blog1.get().getId());
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

//    @PostMapping("/update/{id}")
//    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody BlogForm blogForm) {
//        Optional<Blog> blog = blogService.findById(id);
//        blogForm.setId(blog.get().getId());
//        MultipartFile multipartFile = blogForm.getImage();
//        String fileName = multipartFile.getOriginalFilename();
//        String fileUpload = environment.getProperty("upload.path");
//        Blog blog1 = new Blog(id, fileName, blogForm.getContent());
//        try {
//            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        blogService.save(blog1);
//        return new ResponseEntity<>(blog1, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> removeBlog (@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Blog> removeAllBlog() {
        blogService.removeAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Blog> removeAllBlogByUserId(@PathVariable Long id) {
        blogService.removeAllByUserId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
