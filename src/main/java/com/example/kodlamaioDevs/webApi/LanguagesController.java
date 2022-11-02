package com.example.kodlamaioDevs.webApi;

import com.example.kodlamaioDevs.business.abstracts.LanguageService;
import com.example.kodlamaioDevs.entities.concretes.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public void add(@RequestBody Languages languages) throws Exception {
        languageService.add(languages);
    }

    @DeleteMapping("/delete")
    public void delete(int id) {
        languageService.delete(id);
    }

    @PutMapping("/update")
    public void update(Languages languages) {
        languageService.update(languages);
    }

    @GetMapping("/findbyid")
    public void findById(int id) {
        languageService.findById(id);
    }

    @GetMapping("/getall")
    public List<Languages> getAll() {
        return languageService.getAll();
    }
}
