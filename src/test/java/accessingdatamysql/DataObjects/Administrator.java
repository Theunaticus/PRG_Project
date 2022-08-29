package com.project.accessingdatamysql.DataObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Admin_id;
    private String Admin_name;
    private String password;
    private String contact;

    public int GetId() {
        return Admin_id;
    }

    public void SetId(int _ID) {
        Admin_id = _ID;
    }

    public String GetName() {
        return Admin_name;
    }

    public void SetName(String _Value) {
        Admin_name = _Value;
    }

    public String GetPassword() {
        return password;
    }

    public void SetPassword(String _Value) {
        password = _Value;
    }

    public String GetContact() {
        return contact;
    }

    public void SetContact(String _Value) {
        contact = _Value;
    }

}
