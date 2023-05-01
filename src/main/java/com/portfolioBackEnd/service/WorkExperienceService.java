package com.portfolioBackEnd.service;

import com.portfolioBackEnd.ResourceNotFoundException;
import com.portfolioBackEnd.model.WorkExperience;
import com.portfolioBackEnd.repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkExperienceService {

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    public List<WorkExperience> getAllWorkExperiences() {
        return workExperienceRepository.findAll();
    }

    public WorkExperience getWorkExperienceById(Long id) {
        Optional<WorkExperience> workExperienceOptional = workExperienceRepository.findById(id);
        if (workExperienceOptional.isPresent()) {
            return workExperienceOptional.get();
        } else {
            throw new ResourceNotFoundException("Work Experience", "id", id);
        }
    }

    public WorkExperience createWorkExperience(WorkExperience workExperience) {
        return workExperienceRepository.save(workExperience);
    }

    public WorkExperience updateWorkExperience(Long id, WorkExperience workExperience) {
        Optional<WorkExperience> workExperienceOptional = workExperienceRepository.findById(id);
        if (workExperienceOptional.isPresent()) {
            workExperience.setId(id);
            return workExperienceRepository.save(workExperience);
        } else {
            throw new ResourceNotFoundException("Work Experience", "id", id);
        }
    }

    public void deleteWorkExperience(Long id) {
        Optional<WorkExperience> workExperienceOptional = workExperienceRepository.findById(id);
        if (workExperienceOptional.isPresent()) {
            workExperienceRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Work Experience", "id", id);
        }
    }

}
