package com.example.kodlamaioDevs.webApi;

import com.example.kodlamaioDevs.business.abstracts.ProgrammingLanguageService;
import com.example.kodlamaioDevs.business.abstracts.ProgrammingLanguageTechnologyService;
import com.example.kodlamaioDevs.business.request.CreateProgrammingLanguageTechnologyRequest;
import com.example.kodlamaioDevs.business.request.DeleteProgrammingLanguageTechnologyRequest;
import com.example.kodlamaioDevs.business.request.UpdateProgrammingLanguageTechnologyRequest;
import com.example.kodlamaioDevs.business.responses.GetAllProgrammingLanguageTechnologyResponse;
import com.example.kodlamaioDevs.business.responses.GetByIdProgrammingLanguageTechnologyResponse;
import com.example.kodlamaioDevs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languagestechnology")
public class ProgrammingLanguageTechnologyController {
    private ProgrammingLanguageTechnologyService programmingLanguageTechnologyService;

    @Autowired
    public ProgrammingLanguageTechnologyController(ProgrammingLanguageTechnologyService iProgrammingLanguageTechnologyService) {
        this.programmingLanguageTechnologyService = programmingLanguageTechnologyService;
    }

    @PostMapping("/add")
    public void add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception {
        programmingLanguageTechnologyService.add(createProgrammingLanguageTechnologyRequest);
    }

    @DeleteMapping("/delete{id}")
    public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgramingLanguageTechnologyRequest){
        programmingLanguageTechnologyService.delete(deleteProgramingLanguageTechnologyRequest);
    }

    @PutMapping("/update")
    public void update(UpdateProgrammingLanguageTechnologyRequest updateProgramingLanguageTechnologyRequest){
        programmingLanguageTechnologyService.update(updateProgramingLanguageTechnologyRequest);
    }

    @GetMapping("/findbyid/{id}")
    public GetByIdProgrammingLanguageTechnologyResponse findById(@PathVariable int id) throws Exception{
        return programmingLanguageTechnologyService.findById(id);
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguageTechnologyResponse> getAll(){
        return programmingLanguageTechnologyService.getAll();
    }
}
