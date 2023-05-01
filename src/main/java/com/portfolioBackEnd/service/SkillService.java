package com.portfolioBackEnd.service;

import com.portfolioBackEnd.ResourceNotFoundException;
import com.portfolioBackEnd.model.Skill;
import com.portfolioBackEnd.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SkillService {


    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkill() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(Long id) {
        Optional<Skill> skillOptional = skillRepository.findById(id);
        if (skillOptional.isPresent()) {
            return skillOptional.get();
        } else {
            throw new ResourceNotFoundException("Skill", "id", id);
        }
    }

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill updateSkill(Long id, Skill skill) {
        Optional<Skill> skillOptional = skillRepository.findById(id);
        if (skillOptional.isPresent()) {
           skill.setId(id);
            return skillRepository.save(skill);
        } else {
            throw new ResourceNotFoundException("Skill", "id", id);
        }
    }

    public void deleteSkill(Long id) {
        Optional<Skill> skillOptional = skillRepository.findById(id);
        if (skillOptional.isPresent()) {
            skillRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Skill", "id", id);
        }
    }
}
