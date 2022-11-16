package com.example.kodlamaioDevs.business.concretes;

import com.example.kodlamaioDevs.business.abstracts.ProgrammingLanguageTechnologyService;
import com.example.kodlamaioDevs.business.request.CreateProgrammingLanguageTechnologyRequest;
import com.example.kodlamaioDevs.business.request.DeleteProgrammingLanguageTechnologyRequest;
import com.example.kodlamaioDevs.business.request.UpdateProgrammingLanguageTechnologyRequest;
import com.example.kodlamaioDevs.business.responses.GetAllProgrammingLanguageTechnologyResponse;
import com.example.kodlamaioDevs.business.responses.GetByIdProgrammingLanguageTechnologyResponse;
import com.example.kodlamaioDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.example.kodlamaioDevs.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import com.example.kodlamaioDevs.entities.concretes.ProgrammingLanguage;
import com.example.kodlamaioDevs.entities.concretes.ProgrammingLanguageTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService {

    private final ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;
    private final ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageTechnologyManager(ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageTechnologyRepository = programmingLanguageTechnologyRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public void add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(createProgrammingLanguageTechnologyRequest.getProgrammingLanguageId()).get();
        ProgrammingLanguageTechnology programmingLanguageTechnology = new ProgrammingLanguageTechnology();
        programmingLanguageTechnology.setName(createProgrammingLanguageTechnologyRequest.getName());
        programmingLanguageTechnology.setBelong(programmingLanguage);
        programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);

    }


    @Override
    public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgramingLanguageTechnologyRequest) {
        programmingLanguageTechnologyRepository.deleteById(deleteProgramingLanguageTechnologyRequest.getId());
    }


    @Override
    public void update(UpdateProgrammingLanguageTechnologyRequest updateProgramingLanguageTechnology) {
        ProgrammingLanguageTechnology programmingLanguageTechnology = programmingLanguageTechnologyRepository.getReferenceById(updateProgramingLanguageTechnology.getId());
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(updateProgramingLanguageTechnology.getProgrammingLanguageId());
        programmingLanguageTechnology.setName(updateProgramingLanguageTechnology.getName());
        programmingLanguageTechnology.setBelong(programmingLanguage);
        programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
    }

    @Override
    public GetByIdProgrammingLanguageTechnologyResponse findById(int id) throws Exception {
        List<ProgrammingLanguageTechnology> subLanguages = programmingLanguageTechnologyRepository.findAll();
        GetByIdProgrammingLanguageTechnologyResponse getByIdProgrammingLanguageTechnologyResponse = null;

        for (ProgrammingLanguageTechnology programmingLanguageTechnology : subLanguages) {
            if (programmingLanguageTechnology.getId() == id) {
                getByIdProgrammingLanguageTechnologyResponse = new GetByIdProgrammingLanguageTechnologyResponse();
                getByIdProgrammingLanguageTechnologyResponse.setId(programmingLanguageTechnology.getId());
                getByIdProgrammingLanguageTechnologyResponse.setName(programmingLanguageTechnology.getName());
            }
        }
        if (getByIdProgrammingLanguageTechnologyResponse == null) {
            throw new Exception("The programming language technology of the entered id number could not be found");
        }

        return getByIdProgrammingLanguageTechnologyResponse;
    }

    @Override
    public List<GetAllProgrammingLanguageTechnologyResponse> getAll() {
        List<ProgrammingLanguageTechnology> programmingLanguageTechnologies = programmingLanguageTechnologyRepository.findAll();
        List<GetAllProgrammingLanguageTechnologyResponse> getAllProgrammingLanguageTechnologyResponses = new ArrayList<GetAllProgrammingLanguageTechnologyResponse>();

        for (ProgrammingLanguageTechnology programmingLanguageTechnology : programmingLanguageTechnologies) {
            GetAllProgrammingLanguageTechnologyResponse responseItem = new GetAllProgrammingLanguageTechnologyResponse();
            responseItem.setId(programmingLanguageTechnology.getId());
            responseItem.setName(programmingLanguageTechnology.getName());
            responseItem.setBelong(programmingLanguageTechnology.getBelong());
            getAllProgrammingLanguageTechnologyResponses.add(responseItem);
        }
        return getAllProgrammingLanguageTechnologyResponses;
    }
}
