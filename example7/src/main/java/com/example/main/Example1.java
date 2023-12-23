package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
     
        Vehicle veh1 = context.getBean(Vehicle.class);
        System.out.println("Primary Bean = " + veh1.getName());
        veh1.printHello();
        context.close(); // @PreDestroy annotated method will be called
    }
}
