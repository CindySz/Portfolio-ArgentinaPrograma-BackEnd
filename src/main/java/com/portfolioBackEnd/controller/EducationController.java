package com.portfolioBackEnd.controller;

import com.portfolioBackEnd.model.Education;
import com.portfolioBackEnd.model.dto.EducationDTO;
import com.portfolioBackEnd.service.EducationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/education")
@CrossOrigin
public class EducationController {



    @Autowired
    private EducationService educationService;

    @GetMapping
    public List<EducationDTO> getAllEducation() {
        List<Education> education = educationService.getAllEducation();
        return education.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EducationDTO getEducationById(@PathVariable Long id) {
       Education education = educationService.getEducationById(id);
        return convertToDto(education);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EducationDTO createEducation(@RequestBody EducationDTO educationDTO) {
        Education education = convertToEntity(educationDTO);
        Education savedEducation = educationService.createEducation(education);
        return convertToDto(savedEducation);
    }

    @PutMapping("/{id}")
    public EducationDTO updateEducation(@PathVariable Long id, @RequestBody EducationDTO educationDTO) {
        Education education = convertToEntity(educationDTO);
        Education updatedEducation = educationService.updateEducation(id, education);
        return convertToDto(updatedEducation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }




    private EducationDTO convertToDto(Education education) {
        ModelMapper modelMapper = new ModelMapper();
        EducationDTO educationDTO = modelMapper.map(education, EducationDTO.class);
        return educationDTO;
    }

    private Education convertToEntity(EducationDTO educationDTO) {
        ModelMapper modelMapper = new ModelMapper();
      Education education = modelMapper.map(educationDTO, Education.class);
        return education;
    }
}
