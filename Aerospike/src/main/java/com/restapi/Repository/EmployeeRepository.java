package com.restapi.Repository;



import com.restapi.Model.Employee;
//import com.restapi.Model.Person;

import java.util.List;


public interface EmployeeRepository {

 public String addEmployee(Employee employee);

 List<Employee> getAllEmployee();

 Employee findById(int id);

 String updateEmployee(Employee employee, int id);

 String deleteById(int id);
}


