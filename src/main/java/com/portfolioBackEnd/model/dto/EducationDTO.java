package com.portfolioBackEnd.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationDTO {

    private Long id;
    private String img;
    private String title;
    private String educationalEstablishment;
    private String date;
}
