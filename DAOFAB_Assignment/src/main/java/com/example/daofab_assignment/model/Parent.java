package com.example.daofab_assignment.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "sender", nullable = false)
    private String sender;

    @Column(name = "receiver", nullable = false)
    private String receiver;

    @Column(name = "totalAmount", nullable = false)
    private double totalAmount;
}
