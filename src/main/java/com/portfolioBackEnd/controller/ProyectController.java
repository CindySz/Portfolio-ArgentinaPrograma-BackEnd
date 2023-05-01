package com.portfolioBackEnd.controller;

import com.portfolioBackEnd.model.Proyect;
import com.portfolioBackEnd.model.dto.ProyectDTO;
import com.portfolioBackEnd.service.ProyectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/proyect")
public class ProyectController {

    @Autowired
    private ProyectService proyectService;

    @GetMapping
    public List<ProyectDTO> getAllProyect() {
        List<Proyect> proyect= proyectService.getAllProyect();
        return proyect.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProyectDTO getProyectById(@PathVariable Long id) {
        Proyect proyect= proyectService.getProyectById(id);
        return convertToDto(proyect);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ProyectDTO createProyect(@RequestBody ProyectDTO proyectDTO) {
        Proyect proyect = convertToEntity(proyectDTO);
        Proyect savedProyect = proyectService.createProyect(proyect);
        return convertToDto(savedProyect);
    }


    @PutMapping("/{id}")
    public ProyectDTO updateProyect(@PathVariable Long id, @RequestBody ProyectDTO proyectDTO) {
        Proyect proyect = convertToEntity(proyectDTO);
        Proyect updatedProyect = proyectService.updateProyect(id, proyect);
        return convertToDto(updatedProyect);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProyect(@PathVariable Long id) {
        proyectService.deleteProyect(id);
    }


    private ProyectDTO convertToDto(Proyect proyect) {
        ModelMapper modelMapper = new ModelMapper();
        ProyectDTO proyectDTO = modelMapper.map(proyect, ProyectDTO.class);
        return proyectDTO ;
    }

    private Proyect convertToEntity(ProyectDTO proyectDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Proyect proyect= modelMapper.map(proyectDTO, Proyect.class);
        return proyect;
    }
}
