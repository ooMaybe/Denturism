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
    FINAL_IMPRESSION("white"),
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
    
    public static AppointmentType find(String type) {
        String normalized = type.trim().replace(" ", "_").toUpperCase();
        return Arrays.stream(AppointmentType.values())
                     .filter(appType -> appType.name().equals(normalized))
                     .findFirst()
                     .orElse(null);
    }
}
