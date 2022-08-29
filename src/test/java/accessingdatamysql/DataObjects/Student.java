package com.project.accessingdatamysql.DataObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int student_id;
    private String student_name;
    private String student_address;
    private String student_email;
    private String student_password;

    public int GetId() {
        return student_id;
    }

    public void SetId(int _ID) {
        student_id = _ID;
    }

    public String GetName() {
        return student_name;
    }

    public void SetName(String _Value) {
        student_name = _Value;
    }

    public String GetAddress() {
        return student_address;
    }

    public void SetAddress(String _Value) {
        student_address = _Value;
    }

    public String GetEmail() {
        return student_email;
    }

    public void SetEmail(String _Value) {
        student_email = _Value;
    }

    public String GetPassword() {
        return student_password;
    }

    public void SetPassword(String _Value) {
        student_password = _Value;
    }
}
