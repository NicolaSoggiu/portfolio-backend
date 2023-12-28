package com.example.newportfolio.repository;

import com.example.newportfolio.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

    List<Technology> findByOrderByName();

    boolean existsByName(String name);
}