package io.turntabl.DeveloperProfile.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.turntabl.DeveloperProfile.models.Employee;
import io.turntabl.DeveloperProfile.models.Leave;
import io.turntabl.DeveloperProfile.models.Project;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ReadJsonFromFile {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public Optional<Leave> getLeave(String employeeId) throws IOException {
        List<Leave> leaves = getAllLeave();
        for (Leave leave : leaves) {
            if (leave.getId().equals(employeeId)) {
                return Optional.of(leave);
            }
        }
        return Optional.empty();
    }

    public List<Employee> getAllEmployees() throws IOException {
        List<Employee> employee = new ArrayList<>();

        for (JsonNode next : OBJECT_MAPPER.readTree(new File("src/main/resources/employees.json"))) {
            Employee emp = new Employee();
            emp.setEmployee_id(next.get("employee_id").asInt());
            emp.setEmployee_firstname(next.get("employee_firstname").asText());
            emp.setEmployee_lastname(next.get("employee_lastname").asText());
            emp.setEmployee_onleave(next.get("employee_onleave").asBoolean());
            // emp.setEmployee_hire_date(new Date(next.get("employee_hire_date").asText()));
            emp.setEmployee_address(next.get("employee_address").asText());
            emp.setEmployee_email(next.get("employee_email").asText());
            emp.setEmployee_dev_level(next.get("employee_gender").asText());
            emp.setEmployee_gender(next.get("employee_id").asText());
            emp.setEmployee_phonenumber(next.get("employee_phonenumber").asText());
            List<String> tech_stack = new ArrayList<>();
            for (JsonNode tech: next.get("tech_stack")){
                tech_stack.add(tech.asText());
            }
            emp.setTech_stack( tech_stack);

            List<Project> projects = new ArrayList<>();
            for (JsonNode tech: next.get("project")){
                projects.add(OBJECT_MAPPER.readValue(tech.toPrettyString(), Project.class));
            }
            //System.out.println(next.get("project"));

           // emp.setProjects(OBJECT_MAPPER.readValue(next.get("projects").asText(), new TypeReference<List<Project>>() {}));
            emp.setProjects( projects);
           employee.add(emp);
        }
        return employee;
    }

    private List<Leave> getAllLeave () throws IOException {
        return OBJECT_MAPPER.readValue(new File("src/main/resources/leave.json"), new TypeReference<List<Leave>>() {});
    }

}