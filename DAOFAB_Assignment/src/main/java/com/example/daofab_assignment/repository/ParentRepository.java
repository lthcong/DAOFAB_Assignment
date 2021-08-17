package com.example.daofab_assignment.repository;

import com.example.daofab_assignment.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ParentRepository extends JpaRepository<Parent, Integer> {

    public List<Parent> findAll();

    public Parent save(Parent parent);
}
