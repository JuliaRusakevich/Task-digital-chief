package com.juliar.taskdigitalchief.repository;

import com.juliar.taskdigitalchief.entity.Sight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SightRepository extends JpaRepository<Sight, Long> {

    List<Sight> findAllByCityId(Long id);
}
