package com.example.demo.service;

import com.example.demo.entity.TourOperator;
import com.example.demo.repository.TourOperatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourOperatorService {
    private final TourOperatorRepository tourOperatorRepository;

    public TourOperatorService(TourOperatorRepository tourOperatorRepository) {
        this.tourOperatorRepository = tourOperatorRepository;
    }

    public List<TourOperator> getOperators(){
        return tourOperatorRepository.findAll();
    }



}
