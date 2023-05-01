package com.portfolioBackEnd.service;

import com.portfolioBackEnd.ResourceNotFoundException;
import com.portfolioBackEnd.model.Proyect;
import com.portfolioBackEnd.repository.ProyectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectService {


    @Autowired
    private ProyectRepository proyectRepository;

    public List<Proyect> getAllProyect() {
        return proyectRepository.findAll();
    }

    public Proyect getProyectById(Long id) {
        Optional<Proyect> proyectOptional = proyectRepository.findById(id);
        if (proyectOptional.isPresent()) {
            return proyectOptional.get();
        } else {
            throw new ResourceNotFoundException("Proyect", "id", id);
        }
    }

    public Proyect createProyect(Proyect proyect) {
        return proyectRepository.save(proyect);
    }

    public Proyect updateProyect(Long id, Proyect proyect) {
        Optional<Proyect> proyectOptional = proyectRepository.findById(id);
        if (proyectOptional.isPresent()) {
            proyect.setId(id);
            return proyectRepository.save(proyect);
        } else {
            throw new ResourceNotFoundException("Proyect", "id", id);
        }
    }

    public void deleteProyect(Long id) {
        Optional<Proyect> proyectOptional = proyectRepository.findById(id);
        if (proyectOptional.isPresent()) {
            proyectRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Proyect", "id", id);
        }
    }
}
