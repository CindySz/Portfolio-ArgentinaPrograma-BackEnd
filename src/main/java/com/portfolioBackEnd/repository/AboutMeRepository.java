package com.portfolioBackEnd.repository;

import com.portfolioBackEnd.model.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
    public interface AboutMeRepository extends JpaRepository<AboutMe, Long> {

    }

