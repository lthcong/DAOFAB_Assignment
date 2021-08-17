package com.example.daofab_assignment.controller;

import com.example.daofab_assignment.file.JSONReader;
import com.example.daofab_assignment.model.Child;
import com.example.daofab_assignment.model.Parent;
import com.example.daofab_assignment.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ParentService parentService;

    @GetMapping
    public List<Parent> findAll() {
        return this.parentService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public List<Child> findDetail(@PathVariable int id) {
        return this.parentService.findDetail(id);
    }

}
