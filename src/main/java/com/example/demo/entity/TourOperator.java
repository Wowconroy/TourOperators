package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class TourOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;

    public TourOperator() {
    }

    public TourOperator(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
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
