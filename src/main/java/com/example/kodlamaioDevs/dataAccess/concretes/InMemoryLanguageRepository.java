package com.example.kodlamaioDevs.dataAccess.concretes;

import com.example.kodlamaioDevs.dataAccess.abstracts.LanguageRepository;
import com.example.kodlamaioDevs.entities.concretes.Languages;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    private LanguageRepository languageRepository;
    private List<Languages> language;

    public InMemoryLanguageRepository() {

        language = new ArrayList<Languages>();
        language.add(new Languages(1, "C#"));
        language.add(new Languages(2, ".net"));
        language.add(new Languages(3, "Phyton"));
        language.add(new Languages(4, "Java"));

    }

    @Override
    public void add(Languages languages) {
        language.add(languages);
    }

    @Override
    public void delete(int id) {
        language.remove(id);
    }

    @Override
    public void update(Languages languages) {
        languageRepository.update(languages);
    }

    @Override
    public Languages findById(int id) {
        return language.get(id);
    }

    @Override
    public List<Languages> getAll() {
        return language;
    }
}
