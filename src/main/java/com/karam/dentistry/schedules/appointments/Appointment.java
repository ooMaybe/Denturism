/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.schedules.appointments;

import java.util.UUID;

/**
 *
 * @author karam
 */
public class Appointment {
    
    private String id;
    
    public Appointment(Patient patient){
        id = UUID.randomUUID().toString();
        
    }
    
}
