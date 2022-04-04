package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tour_name")
    private String name;

    private TourType tourType;



}
