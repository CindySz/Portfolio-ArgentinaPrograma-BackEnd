package com.portfolioBackEnd.service;

import com.portfolioBackEnd.ResourceNotFoundException;
import com.portfolioBackEnd.model.Education;
import com.portfolioBackEnd.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {


    @Autowired
    private EducationRepository educationRepository;

    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    public Education getEducationById(Long id) {
        Optional<Education> educationOptional = educationRepository.findById(id);
        if (educationOptional.isPresent()) {
            return educationOptional.get();
        } else {
            throw new ResourceNotFoundException("Education", "id", id);
        }
    }

    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    public Education updateEducation(Long id, Education education) {
        Optional<Education> educationOptional = educationRepository.findById(id);
        if (educationOptional.isPresent()) {
            education.setId(id);
            return educationRepository.save(education);
        } else {
            throw new ResourceNotFoundException("Education", "id", id);
        }
    }

    public void deleteEducation(Long id) {
        Optional<Education> educationOptional = educationRepository.findById(id);
        if (educationOptional.isPresent()) {
           educationRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Education", "id", id);
        }
    }
}
