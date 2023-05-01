package com.portfolioBackEnd.service;

import com.portfolioBackEnd.ResourceNotFoundException;
import com.portfolioBackEnd.model.AboutMe;
import com.portfolioBackEnd.repository.AboutMeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutMeService {

    @Autowired
    private AboutMeRepository aboutMeRepository;

    public List<AboutMe> getAllAboutMe() {
        return aboutMeRepository.findAll();
    }

    public AboutMe getAboutMeById(Long id) {
        Optional<AboutMe> aboutMeOptional = aboutMeRepository.findById(id);
        if (aboutMeOptional.isPresent()) {
            return aboutMeOptional.get();
        } else {
            throw new ResourceNotFoundException("About Me", "id", id);
        }
    }

    public AboutMe createAboutMe(AboutMe aboutMe) {
        return aboutMeRepository.save(aboutMe);
    }

    public AboutMe updateAboutMe(Long id, AboutMe aboutMe) {
        Optional<AboutMe> workExperienceOptional = aboutMeRepository.findById(id);
        if (workExperienceOptional.isPresent()) {
            aboutMe.setId(id);
            return aboutMeRepository.save(aboutMe);
        } else {
            throw new ResourceNotFoundException("About Me", "id", id);
        }
    }

    public void deleteAboutMe(Long id) {
        Optional<AboutMe> aboutMeOptional = aboutMeRepository.findById(id);
        if (aboutMeOptional.isPresent()) {
            aboutMeRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("About Me", "id", id);
        }
    }


}
