package com.portfolioBackEnd.controller;

import com.portfolioBackEnd.model.AboutMe;
import com.portfolioBackEnd.model.dto.AboutMeDTO;
import com.portfolioBackEnd.service.AboutMeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/about-me")
public class AboutMeController {

    @Autowired
    private AboutMeService aboutMeService;

    @GetMapping
    public List<AboutMeDTO> getAllAboutMe() {
        List<AboutMe> aboutMe = aboutMeService.getAllAboutMe();
        return aboutMe.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AboutMeDTO getAboutMeById(@PathVariable Long id) {
        AboutMe aboutMe= aboutMeService.getAboutMeById(id);
        return convertToDto(aboutMe);
    }

   @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AboutMeDTO createAboutMe(@RequestBody AboutMeDTO aboutMeDTO) {
        AboutMe aboutMe = convertToEntity(aboutMeDTO);
        AboutMe savedAboutMe = aboutMeService.createAboutMe(aboutMe);
        return convertToDto(savedAboutMe);
    }


    @PutMapping("/{id}")
    public AboutMeDTO updateAboutMe(@PathVariable Long id, @RequestBody AboutMeDTO aboutMeDTO) {
       AboutMe aboutMe = convertToEntity(aboutMeDTO);
       AboutMe updatedAboutMe = aboutMeService.updateAboutMe(id, aboutMe);
        return convertToDto(updatedAboutMe);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAboutMe(@PathVariable Long id) {
        aboutMeService.deleteAboutMe(id);
    }


    private AboutMeDTO convertToDto(AboutMe aboutMe) {
        ModelMapper modelMapper = new ModelMapper();
        AboutMeDTO aboutMeDTO = modelMapper.map(aboutMe, AboutMeDTO.class);
        return aboutMeDTO;
    }

    private AboutMe convertToEntity(AboutMeDTO aboutMeDTO) {
        ModelMapper modelMapper = new ModelMapper();
        AboutMe aboutMe= modelMapper.map(aboutMeDTO, AboutMe.class);
        return aboutMe;
    }
}
