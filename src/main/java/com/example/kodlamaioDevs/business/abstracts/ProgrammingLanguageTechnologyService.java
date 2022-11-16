package com.example.kodlamaioDevs.business.abstracts;

import com.example.kodlamaioDevs.business.request.CreateProgrammingLanguageTechnologyRequest;
import com.example.kodlamaioDevs.business.request.DeleteProgrammingLanguageTechnologyRequest;
import com.example.kodlamaioDevs.business.request.UpdateProgrammingLanguageTechnologyRequest;
import com.example.kodlamaioDevs.business.responses.GetAllProgrammingLanguageTechnologyResponse;
import com.example.kodlamaioDevs.business.responses.GetByIdProgrammingLanguageTechnologyResponse;

import java.util.List;

public interface ProgrammingLanguageTechnologyService {

    void add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception;

    void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgramingLanguageTechnologyRequest);

    void update(UpdateProgrammingLanguageTechnologyRequest updateProgramingLanguageTechnology);

    GetByIdProgrammingLanguageTechnologyResponse findById(int id) throws Exception;

    List<GetAllProgrammingLanguageTechnologyResponse> getAll();
}
