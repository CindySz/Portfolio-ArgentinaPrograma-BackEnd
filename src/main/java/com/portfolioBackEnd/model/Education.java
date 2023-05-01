package com.portfolioBackEnd.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "education")
@Getter
@Setter
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img")
    private String img;

    @Column(name = "title")
    private String title;

    @Column(name = "educational_establishment")
    private String  educationalEstablishment;

    @Column(name = "date")
    private String date;

}
