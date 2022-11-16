package com.example.kodlamaioDevs.business.concretes;

import com.example.kodlamaioDevs.business.abstracts.ProgrammingLanguageService;
import com.example.kodlamaioDevs.business.request.CreateProgrammingLanguageRequest;
import com.example.kodlamaioDevs.business.request.DeleteProgrammingLanguageRequest;
import com.example.kodlamaioDevs.business.request.UpdateProgrammingLanguageRequest;
import com.example.kodlamaioDevs.business.responses.GetAllProgrammingLanguagesResponse;
import com.example.kodlamaioDevs.business.responses.GetByIdProgrammingLanguageResponse;
import com.example.kodlamaioDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.example.kodlamaioDevs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private final ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository iProgramingLanguageRepository) {
        this.programmingLanguageRepository = iProgramingLanguageRepository;
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgramingLanguageRequest) throws Exception {
        ProgrammingLanguage programingLanguage = new ProgrammingLanguage();
        if (!createProgramingLanguageRequest.getName().isBlank()) {
            for (ProgrammingLanguage l : programmingLanguageRepository.findAll()) {
                if (l.getName().equals(createProgramingLanguageRequest.getName())) {
                    throw new Exception("The name cannot be the same");
                }
            }
        }
        if (createProgramingLanguageRequest.getName().isEmpty()) {
            throw new Exception("Programming language cannot be empty");

        }

        programingLanguage.setName(createProgramingLanguageRequest.getName());
        programmingLanguageRepository.save(programingLanguage);
    }

    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgramingLanguageRequest) {
        programmingLanguageRepository.deleteById(deleteProgramingLanguageRequest.getId());
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgramingLanguageRequest) {
        ProgrammingLanguage programingLanguage = programmingLanguageRepository.getReferenceById(updateProgramingLanguageRequest.getId());
        programingLanguage.setName(updateProgramingLanguageRequest.getName());
        programmingLanguageRepository.save(programingLanguage);
    }

    @Override
    public GetByIdProgrammingLanguageResponse findById(int id) throws Exception {
        List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
        GetByIdProgrammingLanguageResponse getByIdProgramingLanguageResponse = null;

        for (ProgrammingLanguage programingLanguageTemp : languages) {
            if (programingLanguageTemp.getId() == id) {
                getByIdProgramingLanguageResponse = new GetByIdProgrammingLanguageResponse();
                getByIdProgramingLanguageResponse.setId(programingLanguageTemp.getId());
                getByIdProgramingLanguageResponse.setName(programingLanguageTemp.getName());
            }
        }
        if (getByIdProgramingLanguageResponse == null) {
            throw new Exception("The programming language of the entered id number could not be found");
        }
        return getByIdProgramingLanguageResponse;
    }

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        List<ProgrammingLanguage> programingLanguages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesRespons = new ArrayList<GetAllProgrammingLanguagesResponse>();
        for (ProgrammingLanguage programingLanguage : programingLanguages) {
            GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
            responseItem.setId(programingLanguage.getId());
            responseItem.setName(programingLanguage.getName());
            getAllProgrammingLanguagesRespons.add(responseItem);
        }
        return getAllProgrammingLanguagesRespons;
    }
}
