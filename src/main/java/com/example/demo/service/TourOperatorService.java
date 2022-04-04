package com.example.demo.service;

import com.example.demo.entity.TourOperator;
import com.example.demo.repository.TourOperatorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TourOperatorService {
    private final TourOperatorRepository tourOperatorRepository;

    public TourOperatorService(TourOperatorRepository tourOperatorRepository) {
        this.tourOperatorRepository = tourOperatorRepository;
    }

    public List<TourOperator> getOperators(){
        return tourOperatorRepository.findAll();
    }

    public void addNewTourOperator(TourOperator tourOperator){
        Optional<TourOperator> tourOperatorOptional = tourOperatorRepository
                .findByCompanyName(tourOperator.getCompanyName());
        if (tourOperatorOptional.isPresent()) throw new IllegalStateException("Tour operator already exist");
        tourOperatorRepository.save(tourOperator);
    }

    public void deleteTourOperator(Long tourOperatorId){
        boolean exists = tourOperatorRepository.existsById(tourOperatorId);
        if (!exists) {
            throw new IllegalStateException("Tour operator with id: " + tourOperatorId + " does not exists");
        }
        tourOperatorRepository.deleteById(tourOperatorId);
    }

    @Transactional
    public void updateTourOperator(Long tourOperatorId, String companyName) {
        TourOperator tourOperator = tourOperatorRepository.findById(tourOperatorId)
                .orElseThrow(() -> new IllegalStateException
                        ("Tour operator with id: " + tourOperatorId + "does not exist"));
        if (companyName != null &&
                companyName.length() > 0 &&
                !Objects.equals(tourOperator.getCompanyName(), companyName)){
            tourOperator.setCompanyName(companyName);
        }
    }
}
