package com.tts;

public class Entry {
    //All of the fields needed for an entry
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
// default constructor
//    public Entry(){
//        this.firstName = "Default First Name";
//        this.lastName = "Default Last Name";
//        this.phone = "Default Phone Number";
//        this.email = "Default Email";
//    }
//
//    //constructor passing only the name fields
//    public Entry(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = "N/A";
//        this.email = "N/A";
//    }
//    //constructor passing the name and email fields
//    public Entry(String firstName, String lastName, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = "N/A";
//        this.email = email;
//    }


    // constructor passing all of the fields
    public Entry(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
    @Override
    public String toString(){

        return "\n ********* \n First Name: " + this.firstName +
                "\n Last Name: " + this.lastName +
                "\n Phone Number: " + this.phone +
                "\n Email: " + this.email;
    }
//Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
//Setters do I need these?
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
