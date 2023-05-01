package com.portfolioBackEnd.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProyectDTO {

    private Long id;
    private String title;
    private String img;
    private String description;
    private String linkCode;
}
