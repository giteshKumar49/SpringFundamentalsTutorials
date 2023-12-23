package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
     
        Vehicle veh1 = context.getBean(Vehicle.class);
        System.out.println("Primary Bean = " + veh1.getName());

        Vehicle veh2 = context.getBean("hondaVehicle", Vehicle.class);
        System.out.println("Honda Bean = " + veh2.getName());


        Vehicle veh3 = context.getBean("ferrariVehicle", Vehicle.class);
        System.out.println("Ferrari bean = " + veh3.getName());



    }
}
