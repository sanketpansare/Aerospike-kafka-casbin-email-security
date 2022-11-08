package com.restapi;

import com.restapi.Model.Department;
import com.restapi.Model.Employee;
//import com.restapi.Model.Person;

import com.restapi.Repository.EmployeeRepositoryIml;
import com.restapi.Service.EmployeeService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class EmployeeserviceImlTest {
    @Inject
    private EmployeeRepositoryIml employeeRepositoryIml;

    @Inject
    private EmployeeService employeeService;

    @MockBean(EmployeeRepositoryIml.class)
    EmployeeRepositoryIml employeeRepositoryIml() {
        return mock(EmployeeRepositoryIml.class);
    }


    @Test
    public void getAllEmployee() {
        when(employeeRepositoryIml.getAllEmployee()).thenReturn(Stream.of(new Employee(),
                new Employee(),
                new Employee()).collect(Collectors.toList()));

        Assertions.assertEquals(3, employeeService.getAllEmployee().size());
    }

    @Test
    public void addEmployee() {
        //arrange
        Department categories = new Department(12,"java");
        Employee employee = new Employee(12, "hrishi", "hrishikesh22@gmail.com", 2345, "2021-09-07", categories);

        when(employeeService.addEmployee(employee)).thenReturn("Employee saved successfully..!=");

        String result = employeeService.addEmployee(employee);

        assertEquals(result, employeeService.addEmployee(employee));
    }

    @Test
    public void updateEmployee() {
        Department categories = new Department(12,"java");
        Employee employee = new Employee("hrishi", "hrishikesh22@gmail.com", 12345, "2020-04-22",categories);
        employee.setName("hrishi");
        Employee newEmp = new Employee("hrash", "hrishikesh222@gmail.com", 23145, "2032-05-16",categories);

        when(employeeService.updateEmployee(employee, 12)).thenReturn("Employee Updated..!=");

        String result = employeeService.updateEmployee(employee, 12);

        assertEquals(result, employeeService.updateEmployee(employee,12));
    }

    @Test
    public void deleteById() {
        Department categories = new Department(12,"java");
        Employee employee = new Employee("hrishi", "hrishikesh22@gmail.com", 1234, "2019-04-10",categories);
        employee.setId(12);

        when(employeeService.deleteById(12)).thenReturn("Employee Deleted By Id..!=");

        String result = employeeService.deleteById(12);

        assertEquals(result, employeeService.deleteById(12));
    }

}

