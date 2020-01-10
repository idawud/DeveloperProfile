package io.turntabl.DeveloperProfile.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.turntabl.DeveloperProfile.models.Employee;
import io.turntabl.models.Leave;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadJsonFromFile {

    public Leave getLeave() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("leave.json"), Leave.class);
    }

    public List<Employee> getAllEmployees() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("employees.json"), new TypeReference<List<Employee>>(){});
    }
}
