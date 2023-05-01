package com.portfolioBackEnd.controller;

import com.portfolioBackEnd.model.Skill;
import com.portfolioBackEnd.model.dto.SkillDTO;
import com.portfolioBackEnd.service.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<SkillDTO> getAllSkill() {
        List<Skill> skill= skillService.getAllSkill();
        return skill.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SkillDTO getSkillById(@PathVariable Long id) {
        Skill skill= skillService.getSkillById(id);
        return convertToDto(skill);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SkillDTO createSkill(@RequestBody SkillDTO skillDTO) {
       Skill skill = convertToEntity(skillDTO);
        Skill savedSkill = skillService.createSkill(skill);
        return convertToDto(savedSkill);
    }


    @PutMapping("/{id}")
    public SkillDTO updateSkill(@PathVariable Long id, @RequestBody SkillDTO skillDTO) {
        Skill skill = convertToEntity(skillDTO);
        Skill updatedSkill = skillService.updateSkill(id, skill);
        return convertToDto(updatedSkill);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }


    private SkillDTO convertToDto(Skill skill) {
        ModelMapper modelMapper = new ModelMapper();
        SkillDTO skillDTO = modelMapper.map(skill, SkillDTO.class);
        return skillDTO ;
    }

    private Skill convertToEntity(SkillDTO skillDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Skill skill= modelMapper.map(skillDTO, Skill.class);
        return skill;
    }
}
