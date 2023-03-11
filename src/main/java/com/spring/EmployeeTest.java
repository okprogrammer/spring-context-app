package com.spring;

import com.spring.beans.Employee;
import com.spring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeTest {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Employee e = context.getBean("employee", Employee.class);
//        e.setId(2);
//        e.setName("Ravindra");
        System.out.println(e);
        context.close();
    }
}
