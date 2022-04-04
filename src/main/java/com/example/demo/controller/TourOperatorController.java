package com.example.demo.controller;

import com.example.demo.entity.TourOperator;
import com.example.demo.service.TourOperatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tour-operator")
public class TourOperatorController {

    private final TourOperatorService tourOperatorService;

    public TourOperatorController(TourOperatorService tourOperatorService) {
        this.tourOperatorService = tourOperatorService;
    }

    @GetMapping
    public List <TourOperator> getAllOperators(){
        return tourOperatorService.getOperators();
    }

}
