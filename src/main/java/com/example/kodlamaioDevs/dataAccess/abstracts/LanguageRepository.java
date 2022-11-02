package com.example.kodlamaioDevs.dataAccess.abstracts;

import com.example.kodlamaioDevs.entities.concretes.Languages;

import java.util.List;

public interface LanguageRepository {

    void add(Languages languages);

    void delete(int id);

    void update(Languages languages);

    Languages findById(int id);

    List<Languages> getAll();
}
