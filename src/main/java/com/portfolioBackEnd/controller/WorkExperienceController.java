package com.portfolioBackEnd.controller;

import com.portfolioBackEnd.model.WorkExperience;
import com.portfolioBackEnd.model.dto.WorkExperienceDTO;
import com.portfolioBackEnd.service.WorkExperienceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/work-experiences")
@CrossOrigin
public class WorkExperienceController {
    @Autowired
    private WorkExperienceService workExperienceService;

    @GetMapping
    public List<WorkExperienceDTO> getAllWorkExperiences() {
        List<WorkExperience> workExperiences = workExperienceService.getAllWorkExperiences();
        return workExperiences.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WorkExperienceDTO getWorkExperienceById(@PathVariable Long id) {
        WorkExperience workExperience = workExperienceService.getWorkExperienceById(id);
        return convertToDto(workExperience);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public WorkExperienceDTO createWorkExperience(@RequestBody WorkExperienceDTO workExperienceDTO) {
        WorkExperience workExperience = convertToEntity(workExperienceDTO);
        WorkExperience savedWorkExperience = workExperienceService.createWorkExperience(workExperience);
        return convertToDto(savedWorkExperience);
    }

    @PutMapping("/{id}")
    public WorkExperienceDTO updateWorkExperience(@PathVariable Long id, @RequestBody WorkExperienceDTO workExperienceDTO) {
        WorkExperience workExperience = convertToEntity(workExperienceDTO);
        WorkExperience updatedWorkExperience = workExperienceService.updateWorkExperience(id, workExperience);
        return convertToDto(updatedWorkExperience);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorkExperience(@PathVariable Long id) {
        workExperienceService.deleteWorkExperience(id);
    }




    private WorkExperienceDTO convertToDto(WorkExperience workExperience) {
        ModelMapper modelMapper = new ModelMapper();
        WorkExperienceDTO workExperienceDTO = modelMapper.map(workExperience, WorkExperienceDTO.class);
        return workExperienceDTO;
    }

    private WorkExperience convertToEntity(WorkExperienceDTO workExperienceDTO) {
        ModelMapper modelMapper = new ModelMapper();
        WorkExperience workExperience = modelMapper.map(workExperienceDTO, WorkExperience.class);
        return workExperience;
    }

}
