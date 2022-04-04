package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "tour_operator_tour", joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_operator_id"))
    private Set<TourOperator> tourOperators = new HashSet<>();

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

    public Set<TourOperator> getTourOperators() {
        return tourOperators;
    }

    public void setTourOperators(Set<TourOperator> tourOperators) {
        this.tourOperators = tourOperators;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
