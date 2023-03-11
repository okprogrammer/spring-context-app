package com.spring.config;

import com.spring.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.spring.beans")
public class ProjectConfig {

    @Bean
    public Vehicle vehicle() {
        Vehicle v = new Vehicle("Audi");
        return v;
    }

    @Bean(name = "roylsRoyce")
    public Vehicle vehicle1() {
        Vehicle v = new Vehicle("Royls Royce");
        return v;
    }

    @Bean(value = "rangeRover")
    public Vehicle vehicle2() {
        Vehicle v = new Vehicle("Range Rover");
        return v;
    }

    @Primary
    @Bean(value = "audi")
    public Vehicle vehicle3() {
        Vehicle v = new Vehicle("Audi");
        return v;
    }
}
