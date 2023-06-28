package com.juliar.taskdigitalchief.service.api;

import java.util.List;
import java.util.Optional;

public interface IService<E, C, R> {

    void add(C dto);

    Optional<R> updateInfo(C dto, Long id);

    Optional<R> findById(Long id);

    List<R> findAll();

    void delete(Long id);
}
