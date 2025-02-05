/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.data;

import java.util.UUID;

/**
 *
 * @author karam
 */
public class Patient {
    
    private final UUID uid;
    
    // Personal Information
    
    private String firstName;
    private String lastName;
    private String middleName;
    private String dob;
    private String gender;
    private String citizenship;
    private String occupation;
    private String nationality;
    private String email;
    
    // Address
    private String address;
    private String streetNumber;
    private String province;
    private String city;
    private String postalCode;
    private String phoneNumber;
    
    // Insurance
    private String insuranceCompany;
    private String idNumber;
    private String employer;
    private String companyTelephone;
    
    public Patient(UUID uid){
      this.uid = uid;   
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCompanyName(String companyName) {
        this.insuranceCompany = companyName;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    public UUID getUid() {
        return uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompanyName() {
        return insuranceCompany;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getEmployer() {
        return employer;
    }

    public String getCompanyTelephone() {
        return companyTelephone;
    }
    
    
}
