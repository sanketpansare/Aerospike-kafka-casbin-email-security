package com.restapi.Repository;


import com.restapi.Configuration.aeroMapperConfig;
import com.restapi.Email.EmailDetails;
import com.restapi.Model.Employee;
import com.restapi.Service.EmailService;
import com.restapi.kafka.SendPersonNotification;
import jakarta.inject.Inject;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.serialization.IntegerSerializer;
//import org.apache.kafka.common.serialization.StringSerializer;

import java.util.List;
//import java.util.Properties;
//
//import static org.apache.kafka.common.resource.ResourceType.TOPIC;

public class EmployeeRepositoryIml implements EmployeeRepository {
    @Inject
    aeroMapperConfig mapper;

    @Inject
    EmailService emailService;
    @Inject
    SendPersonNotification sendPersonNotification;
//    @Inject
//    SendEmailNotification sendEmailNotification;


    @Override
    public String addEmployee(Employee employee) {
       mapper.getMapper().save(employee);
         sendPersonNotification.sendPersonNotification("Employee addded..!"+employee);
        // sendEmailNotification.sendEmailNotification("dfhhadfhi"+person.getEmail(),"Person alerts!!");
       EmailService.sendEmail(new EmailDetails("Employee Information Alert !!!", "Congratulations, Employee Info added "+employee.getName()+", Your Employee Id is "+employee.getId(), employee.getEmail()));
        return "Employee saved successfully..!="+employee.getId();
    }
    @Override
    public List<Employee> getAllEmployee(){

        sendPersonNotification.sendPersonNotification("Get All Employee Info..!"+mapper.getMapper().scan(Employee.class));
       return mapper.getMapper().scan(Employee.class);

       // EmailService.sendEmail(new EmailDetails("Person Information Alert !!!", "Congratulations, Person Info updated "+Person.class.getName()+", Your Person Id is "+person.);
    }
@Override
    public Employee findById(int id) {
    sendPersonNotification.sendPersonNotification("Get Employee Info By Id ..!"+mapper.getMapper().read(Employee.class,id));
        return mapper.getMapper().read(Employee.class, id);

    }
    @Override
    public String updateEmployee(Employee employee, int id) {
        Employee p = mapper.getMapper().read(Employee.class,id);
           // p.setId(person.getId());
            p.setName(employee.getName());
            p.setEmail(employee.getEmail());
            p.setJoiningDate(employee.getJoiningDate());
            p.setSal(employee.getSal());
            p.setCategories(employee.getCategories());


            mapper.getMapper().save(p);
        sendPersonNotification.sendPersonNotification("Employee Info Updated Successfully..!"+employee);
        EmailService.sendEmail(new EmailDetails("Employee Information Alert !!!", "Congratulations, Employee Info updated..!= "+employee.getName()+", Your Employee Id is "+employee.getId(), employee.getEmail()));
            return "Employee Updated..!="+p.getId();
    }
    @Override
    public String deleteById(int id) {
        mapper.getMapper().delete(Employee.class,id);
        sendPersonNotification.sendPersonNotification("Employee Deleted Successfully..!"+id);
        //EmailService.sendEmail(new EmailDetails("Person Information Alert !!!", "Congratulations, Person Info Data Deleted "+Person.class.getName()+"Person deleted Id"+mapper.getMapper().delete(Person.class)));
        return "Employee Deleted By Id..!="+id;

    }
}
