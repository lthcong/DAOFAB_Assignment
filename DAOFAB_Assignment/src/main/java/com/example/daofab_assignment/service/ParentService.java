package com.example.daofab_assignment.service;

import com.example.daofab_assignment.file.JSONReader;
import com.example.daofab_assignment.model.Child;
import com.example.daofab_assignment.model.Parent;
import com.example.daofab_assignment.repository.ChildRepository;
import com.example.daofab_assignment.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    public List<Parent> findAll() {
        JSONReader jsonReader = new JSONReader();
        List<Parent> parents = jsonReader.readParent();
        List<Child> children = jsonReader.readChild();

        for (Parent parent : parents) {
            double totalPaidAmount = 0.0;
            for (Child child : children) {
                totalPaidAmount += child.getPaidAmount();
            }
            parent.setTotalPaidAmount(totalPaidAmount);
        }
        return parents;
    }

    public List<Child> findDetail(int parentId) {
        JSONReader jsonReader = new JSONReader();
        List<Parent> parents = jsonReader.readParent().stream().filter(parent -> parent.getId() == parentId).collect(Collectors.toList());
        if (parents.isEmpty()) {
            return new ArrayList<>();
        }
        else {
            Parent parent = parents.get(0);
            List<Child> children = jsonReader.readChild().stream().filter(child -> child.getParentId() == parentId).collect(Collectors.toList());
            for (Child child : children) {
                child.setReceiver(parent.getReceiver());
                child.setSender(parent.getSender());
                child.setTotalAmount(parent.getTotalAmount());
            }

            return children;
        }
    }

    public Parent save(Parent parent) {
        return this.parentRepository.save(parent);
    }
}
