package io.turntabl.DeveloperProfile.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.DeveloperProfile.models.Employee;
import io.turntabl.DeveloperProfile.models.Leave;
import io.turntabl.DeveloperProfile.service.ReadJsonFromFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api
@RestController
@CrossOrigin(origins = "*")
public class DummyEmployees {
    @Autowired
    private ReadJsonFromFile jsonFromFile;

    @ApiOperation("Get all employees in record")
    @GetMapping("/employees")
    public List<Employee> getCustomer(){
        try {
            List<Employee> allEmployees = jsonFromFile.getAllEmployees();
            allEmployees.addAll(jsonFromFile.getAllEmployees().subList(0,2));
            return allEmployees;
        }catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @ApiOperation("get the the day a developer is going on leave and when he/she is coming back")
    @GetMapping(value = "/leave/{employeeId}", produces = "application/json")
    public Leave deleteCustomer(
            @PathVariable("employeeId") String employeeId
    ){
        try {
            return jsonFromFile.getLeave(employeeId).orElse(new Leave());
        }catch (Exception e) {
            e.printStackTrace();
            return new Leave();
        }
    }
}
