package com.portfolioBackEnd.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkExperienceDTO {
    private Long id;
    private String img;
    private String job;
    private String date;
    private String companyName;
    private String description;


}
