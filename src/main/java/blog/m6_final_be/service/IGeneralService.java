package blog.m6_final_be.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save (T t);
    void remove (Long id);
    void removeAll();
}
