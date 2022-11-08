package com.restapi.Controller;

import com.restapi.Model.CustomResponse;
import com.restapi.Model.Employee;
//import com.restapi.Model.Person;
import com.restapi.Service.EmployeeService;
import com.restapi.Service.EmployeeServiceIml;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;


@Controller("/Employee")

@Tag(name = "Employee Details")
@Secured({SecurityRule.IS_AUTHENTICATED})

public class EmployeeController {
    private static Logger logger = (Logger) LogManager.getLogger(EmployeeController.class.getName());
    @Inject
    EmployeeService employeeService;


    @Post(value = "/add")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<CustomResponse> addEmployee(@Body Employee employee){
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> addEmployee(@Body Employee employee)");
        return HttpResponse.ok(new CustomResponse(employeeService.addEmployee(employee)));
    }
    @Get(value = "/GetallEmployee")
    public  HttpResponse<List<Employee>> getAllEmployee(){
        logger.info(getClass().getName() + " .HttpResponse<List<Employee>> getAllEmployee()");
        List<Employee> employee = employeeService.getAllEmployee();

        if (employee.size() >= 0) {
            return HttpResponse.ok().body(employee);
        }
        return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Get(value = "/getemployee/{id}")
    public HttpResponse <Employee> getEmployeeById(@PathVariable("id") int id){
        logger.info(getClass().getName() + " .HttpResponse <Employee> getEmployeeById(@PathVariable(id) int id)");
        Employee employee = employeeService.getEmployeeById(id);

        if(employee != null){
            return HttpResponse.ok().body(employee);
        }
        else
            return HttpResponse.status(HttpStatus.NOT_FOUND);
    }

    @Put(value = "/update/{id}")
    public HttpResponse<CustomResponse> updateEmployee(@Body Employee employee , @PathVariable("id") int id ){
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> updateEmployee(@Body Employee employee ,@PathVariable(id) int id)");
        return HttpResponse.ok(new CustomResponse(employeeService.updateEmployee(employee, id)));

    }
    @Delete(value = "/delete/{id}")
    public HttpResponse<CustomResponse> deleteById(int id){
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> deleteById(int id)");

        return HttpResponse.ok(new CustomResponse(employeeService.deleteById(id)));
    }



}
