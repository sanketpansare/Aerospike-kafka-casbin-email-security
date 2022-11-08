package com.restapi;

import com.restapi.Controller.EmployeeController;
//import com.restapi.Controller.PersonController;
import com.restapi.Model.Department;

import com.restapi.Model.Employee;
//import com.restapi.Model.Person;

import com.restapi.Repository.EmployeeRepositoryIml;


import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@MicronautTest
public class EmployeeControllerImlTest {
    @Inject
    private EmployeeRepositoryIml employeeRepositoryIml;

    @Inject
    private EmployeeController employeeController;
   // private CustomResponse Ok;

    @MockBean(EmployeeRepositoryIml.class)
    EmployeeRepositoryIml employeeRepositoryIml() {
        return mock(EmployeeRepositoryIml.class);
    }



    @Test
    public void getAllPerson(){
        when(employeeRepositoryIml.getAllEmployee()).thenReturn(Stream.of(new Employee(),
                new Employee(),
                new Employee()).collect(Collectors.toList()));

        Assertions.assertEquals(3,employeeController.getAllEmployee().body().size());
    }
    @Test
    public void addEmployee() {
        //arrange
        Department categories = new Department(12,"java");
        Employee employee = new Employee(12,"hrishi","hrishikesh22@gmail.com", 2345,"2012-09-26",categories);

     //when(personController.addPerson(person)).thenReturn(HttpResponse.ok(new CustomResponse(personController.addPerson(person))));

      String result = String.valueOf(employeeController.addEmployee(employee));
      System.out.println(" result : "+result);

        assertEquals(result,"200 Ok" );
    }
    @Test
    public void updateEmployee(){
        Department categories = new Department(12,"java");
        Employee employee = new Employee(12,"hrishi","hrishikesh22@gmail.com",2345,"2023-09-12",categories);
        employee.setName("hrishi");
        Employee newEmp= new Employee("hrash","hrishikesh222@gmail.com",23145,"2022-05-12",categories);

        //when(personController.updatePerson(person,12)).thenReturn("Person Updated..!=");

        String result = String.valueOf(employeeController.updateEmployee(employee,12));

        assertEquals(result,"200 Ok" );
    }
    @Test
    public void deleteById(){
        Department categories = new Department(12,"java");
        Employee employee = new Employee("hrishi","hrishikesh22@gmail.com",1234,"2022-03-22",categories);
        employee.setId(12);

        //when(personController.deleteById(12)).thenReturn("Person Deleted By Id..!=");

        String result = String.valueOf(employeeController.deleteById(12));

        assertEquals(result, "200 Ok");
    }
}
