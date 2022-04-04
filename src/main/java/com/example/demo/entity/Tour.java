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

    @Enumerated(EnumType.STRING)
    private TourType tourType;

    public Tour() {
    }

    public Tour(String name, TourType tourType) {
        this.name = name;
        this.tourType = tourType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tourType=" + tourType +
                '}';
    }
}
