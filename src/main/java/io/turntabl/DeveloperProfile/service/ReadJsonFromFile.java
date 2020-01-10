package io.turntabl.DeveloperProfile.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.turntabl.DeveloperProfile.models.Employee;
import io.turntabl.DeveloperProfile.models.Leave;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ReadJsonFromFile {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public Optional<Leave> getLeave(String employeeId) throws IOException {
        List<Leave> leaves = getAllLeave();
        for (Leave leave : leaves) {
            if ( leave.getId().equals(employeeId)){ return Optional.of(leave);}
        }
        return Optional.empty();
    }

    public List<Employee> getAllEmployees() throws IOException {
        return OBJECT_MAPPER.readValue(new File("src/main/resources/employees.json"), new TypeReference<List<Employee>>(){});
    }

    private List<Leave> getAllLeave() throws IOException {
        return OBJECT_MAPPER.readValue(new File("src/main/resources/leave.json"), new TypeReference<List<Leave>>(){});
    }
}
