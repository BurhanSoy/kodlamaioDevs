package com.example.kodlamaioDevs.dataAccess.abstracts;

import com.example.kodlamaioDevs.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Integer> {

    ProgrammingLanguage getReferenceById(int programmingLanguageId);
}
