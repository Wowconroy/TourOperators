package com.example.demo.repository;

import com.example.demo.entity.TourOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourOperatorRepository extends JpaRepository<TourOperator, Long> {
    Optional<TourOperator> findByCompanyName(String companyName);

}
