package com.example.kodlamaioDevs.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguagesResponse {
    private int id;
    private String name;
}
