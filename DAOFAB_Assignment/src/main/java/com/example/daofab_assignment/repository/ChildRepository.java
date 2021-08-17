package com.example.daofab_assignment.repository;

import com.example.daofab_assignment.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ChildRepository extends JpaRepository<Child, Integer> {

    public List<Child> findAll();

    public Child save(Child child);
}
