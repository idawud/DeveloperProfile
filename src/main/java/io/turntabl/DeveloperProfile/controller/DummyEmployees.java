package io.turntabl.DeveloperProfile.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.DeveloperProfile.models.Employee;
import io.turntabl.models.Leave;
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

    @ApiOperation("Get all employees in record")
    @GetMapping("/customer")
    public List<Employee> getCustomer(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        return employees;
    }

    @ApiOperation("get the the day a developer is going on leave and when he/she is coming back")
    @GetMapping(value = "/leave/{employeeId}", produces = "application/json")
    public Leave deleteCustomer(
            @PathVariable("employeeId") long id
    ){
        return new Leave();
    }
}
