package com.example.kodlamaioDevs.business.concretes;

import com.example.kodlamaioDevs.business.abstracts.LanguageService;
import com.example.kodlamaioDevs.dataAccess.abstracts.LanguageRepository;
import com.example.kodlamaioDevs.entities.concretes.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private List<Languages> language;
    private LanguageRepository languageRepository;
    @Autowired
    public LanguageManager(LanguageRepository iLanguageRepository, List<Languages> language) {
        this.language = language;
        this.languageRepository = iLanguageRepository;
    }

    @Override
    public void add(Languages languages) throws Exception {
        if (languages.getName().isBlank()== false){
            for (Languages l : languageRepository.getAll()) {
                if (l.getName().equals(languages.getName())){
                    throw new Exception("The name cannot be the same");
                }
            }
            languageRepository.add(languages);
        }else {
            throw new Exception("Programming language cannot be empty");
        }
    }

    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    @Override
    public void update(Languages languages) {
        for (Languages l : language) {
            if(l.getId()==languages.getId()){
                l.setName(languages.getName());
            }
        }
    }

    @Override
    public Languages findById(int id) {
        for (Languages i:language) {
            if (i.getId()==id){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Languages> getAll() {
        return languageRepository.getAll();
    }
}
