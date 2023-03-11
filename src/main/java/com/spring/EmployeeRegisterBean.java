package com.spring;

import com.spring.beans.Employee;
import com.spring.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class EmployeeRegisterBean {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Employee eRaju = new Employee(2, "Permit");
        Supplier<Employee> eRajuSupplier = () -> eRaju;
        Supplier<Employee> empSupplier = () -> {
            Employee e = new Employee(3, "Alaxander");
            return e;
        };
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println("randomNumber =" + i);
        if ((i % 2) == 0) {
            context.registerBean("permit", Employee.class, eRajuSupplier);
        } else {
            context.registerBean("alaxander", Employee.class, empSupplier);
        }

        Employee e1 = null;
        Employee e2 = null;
        try {
            e1 = context.getBean("permit", Employee.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating employee raju.");
        }
        try {
            e2 = context.getBean("alaxander", Employee.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating employee gana.");
        }
        if (null != e1) {
            System.out.println("Programming Employee name from Spring Context is: " + e1);
        } else if (null != e2) {
            System.out.println("Programming Employee name from Spring Context is: " + e2);
        } else {
            System.out.println("No Bean is present.");
        }
    }
}
