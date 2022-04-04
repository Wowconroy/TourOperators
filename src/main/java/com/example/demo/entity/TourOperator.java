package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
public class TourOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;

    @ManyToMany(mappedBy = "tourOperators")
    private Set<Tour> tours = new HashSet<>();

    public TourOperator() {
    }

    public TourOperator(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "TourOperator{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
