package com.restapi.Service;

import com.restapi.Model.Employee;

import com.restapi.Repository.EmployeeRepositoryIml;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class EmployeeServiceIml implements EmployeeService {
    @Inject
    EmployeeRepositoryIml employeeRepository;

    @Inject
    EmailService emailRepository;

    @Override
    public String addEmployee(Employee employee) {

        return employeeRepository.addEmployee(employee);
    }
   public List<Employee> getAllEmployee(){
        return employeeRepository.getAllEmployee();
   }

    @Override
    public Employee getEmployeeById(int id) {

        return employeeRepository.findById(id);

    }


    @Override
    public String updateEmployee(Employee employee, int id) {
        return employeeRepository.updateEmployee(employee, id);
    }
    public String deleteById(int id){
     return employeeRepository.deleteById(id);
    }

//
//@Override
//    		 public Page<Person> findEmployeesWithPagination(int pagenumber, int pageSize){
//		        Page<Person> person = employeeRepository.getAllPerson(pa.of(pagenumber, pageSize));
//		        return  person;
//		    }
//@Override
//		    public Page<Person> findEmployeesWithPaginationAndSorting(int offset, int pageSize, String field){
//		        Page<Person> employee = employeeRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
//		        return  employee;
//		    }

}
