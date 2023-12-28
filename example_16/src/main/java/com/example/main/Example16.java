package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example16 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean("vehicleServices",VehicleServices.class);
        System.out.println("Hashcode of the object vehicleServices1 : " +vehicleServices1.hashCode());
        System.out.println("Hashcode of the object vehicleServices2 : " +vehicleServices2.hashCode());
        if(vehicleServices1 == vehicleServices2){
            System.out.println("VehicleServices bean is a Singleton scoped bean");
        }
        else {
            System.out.println("VehicleServices bean is a Prototype scoped bean");
        }


        /*
        * NOTE:
        *What I mean with this statement is you have a vehicle service, inside vehicle injected inside this vehicle
        bean, you can refer to this vehicle service 1000 times, but you will get only same one instance because
        your parent vehicle is of scope
        singleton but if your parent scope also is of type prototype, then definitely if you try to refer to
        the vehicle service bean 1000 times inside your vehicle dot Java class, you will get 1000 different
        object instances.

        So that's why please be very careful when you are injecting prototype beans into singleton beans because
        *
        *
        *
        * please make a note that inside prototype bean scope we don't have a concept of eager initialization
          and in some sense we can consider it as an lazy initialization because whenever we're trying to refer,
          you get a new object created.
          But this is completely different from what we talked inside singleton scope in terms of eager and lazy
          initialization.
          *
          * So that's why whenever someone trying to make a statement that inside prototype scope we have eager
            initialization and lazy initialization, please stop them saying that these kind of initialization is
            not applicable for prototype scope beans.
        * */
    }
}
