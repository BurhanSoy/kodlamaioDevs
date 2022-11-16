package com.example.kodlamaioDevs.dataAccess.abstracts;

import com.example.kodlamaioDevs.entities.concretes.ProgrammingLanguageTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammingLanguageTechnologyRepository extends JpaRepository<ProgrammingLanguageTechnology,Integer> {

}
