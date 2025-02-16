/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.schedules.appointments;

import java.util.Arrays;

/**
 *
 * @author karam
 */
public enum AppointmentType {
    
    CONSULTATION("blue"),
    PRELIMINARY_IMPRESSION("green"),
    BITE_REGISTRATION("yellow"),
    FINAL_IMPRESSION("pink"),
    TRY_IN("brown"),
    DELIVERY("orange"),
    EMERGENCY("red");
    
    private String color;
    
    AppointmentType(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    public static AppointmentType find(String type){
        return Arrays.asList(AppointmentType.values())
                .stream()
                .filter(appType -> appType.equals(type.replace(" ", "_")))
                .findFirst().orElse(null);
    }
}
