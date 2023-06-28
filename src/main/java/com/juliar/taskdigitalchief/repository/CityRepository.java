package com.juliar.taskdigitalchief.repository;

import com.juliar.taskdigitalchief.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository <City, Long> {
}
