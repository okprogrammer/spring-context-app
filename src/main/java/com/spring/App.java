package com.spring;

import com.spring.beans.Vehicle;
import com.spring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("BMW");
        System.out.println("My beautiful vehicle name is coming from non-context: " + vehicle.getName());
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle v1 = context.getBean("audi", Vehicle.class);
        System.out.println("My beautiful vehicle is coming from spring-context: " + v1.getName());
        Vehicle v2 = context.getBean("rangeRover", Vehicle.class);
        System.out.println("My beautiful vehicle is coming from spring-context: " + v2.getName());
        Vehicle v3 = context.getBean("roylsRoyce", Vehicle.class);
        System.out.println("My beautiful vehicle is coming from spring-context: " + v3.getName());

        Vehicle v4 = context.getBean(Vehicle.class);
        System.out.println("My Default beautiful vehicle is coming from spring-context: " + v4.getName());
    }
}
