package com.example.demo.repository;

import com.example.demo.entity.TourOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourOperatorRepository extends JpaRepository<TourOperator, Long> {

}
