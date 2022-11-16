package com.example.kodlamaioDevs.webApi;

import com.example.kodlamaioDevs.business.abstracts.ProgrammingLanguageService;
import com.example.kodlamaioDevs.business.request.CreateProgrammingLanguageRequest;
import com.example.kodlamaioDevs.business.request.DeleteProgrammingLanguageRequest;
import com.example.kodlamaioDevs.business.request.UpdateProgrammingLanguageRequest;
import com.example.kodlamaioDevs.business.responses.GetAllProgrammingLanguagesResponse;
import com.example.kodlamaioDevs.business.responses.GetByIdProgrammingLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService languageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService iLanguageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProgrammingLanguageRequest createProgramingLanguageRequest) throws Exception {
        languageService.add(createProgramingLanguageRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(DeleteProgrammingLanguageRequest deleteProgramingLanguageRequest) {
        languageService.delete(deleteProgramingLanguageRequest);
    }

    @PutMapping("/update")
    public void update(UpdateProgrammingLanguageRequest updateProgramingLanguageRequest) {
        languageService.update(updateProgramingLanguageRequest);
    }

    @GetMapping("/findbyid/{id}")
    public GetByIdProgrammingLanguageResponse findById(@PathVariable int id) throws Exception {
        return languageService.findById(id);
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        return languageService.getAll();
    }
}
