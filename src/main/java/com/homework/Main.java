package com.homework;

import com.homework.configurations.AppConfig;
import com.homework.model.Employee;
import com.homework.services.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext cnt = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService es = cnt.getBean(EmployeeService.class);

        System.out.println(es.listEmployees().get(0).getLastName());

    }
}
