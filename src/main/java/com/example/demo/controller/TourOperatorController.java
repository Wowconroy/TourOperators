package com.example.demo.controller;

import com.example.demo.entity.TourOperator;
import com.example.demo.service.TourOperatorService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void addNewTourOperator(@RequestBody TourOperator tourOperator){
        tourOperatorService.addNewTourOperator(tourOperator);
    }

    @DeleteMapping("{tourOperatorId}")
    public void deleteTourOperator(@PathVariable Long tourOperatorId){
        tourOperatorService.deleteTourOperator(tourOperatorId);
    }

    @PutMapping("{tourOperatorId}")
    public void updateTourOperator(@PathVariable Long tourOperatorId,
                                   @RequestParam (required = false) String companyName){
        tourOperatorService.updateTourOperator(tourOperatorId, companyName);
    }
}
