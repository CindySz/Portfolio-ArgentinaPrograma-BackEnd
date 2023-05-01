package com.portfolioBackEnd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "proyect")
@Getter
@Setter
public class Proyect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "img")
    private String img;


    @Column(name = "description")
    private String  description;

    @Column(name = "link_code")
    private String linkCode;

}
