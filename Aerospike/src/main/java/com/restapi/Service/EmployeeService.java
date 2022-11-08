package com.restapi.Service;

import com.restapi.Model.Employee;
//import com.restapi.Model.Person;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public interface EmployeeService {
   public String addEmployee(Employee employee);
    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    String updateEmployee(Employee employee, int id);

    String deleteById(int id);
//
//    Page<Person> findEmployeesWithPagination(int pagenumber, int pageSize);
//
//    Page<Person> findEmployeesWithPaginationAndSorting(int offset, int pageSize, String field);
}


