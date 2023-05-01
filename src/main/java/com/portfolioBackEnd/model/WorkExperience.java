package com.portfolioBackEnd.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "work_experience")
@Getter @Setter
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img")
    private String img;

    @Column(name = "job")
    private String job;

    @Column(name = "date")
    private String date;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "description")
    private String description;


}
