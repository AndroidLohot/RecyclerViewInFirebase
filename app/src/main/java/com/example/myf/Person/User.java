package com.example.myf.Person;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class User implements Serializable {

    private String uId;
    private String First_Name;
    private String Last_Name;
    private int Age;
    private float Salory;
    private String Phone;


    public User() {
    }

    public User(String first_Name, String last_Name, int age, float salory, String phone) {
        First_Name = first_Name;
        Last_Name = last_Name;
        Age = age;
        Salory = salory;
        Phone = phone;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public float getSalory() {
        return Salory;
    }

    public void setSalory(float salory) {
        Salory = salory;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return First_Name;
    }


    @Override
    public boolean equals(@Nullable Object obj) {

        if (obj instanceof User)
        {
            User user=(User)obj;
            return this.uId.equals(user.getuId());
        }
        return false;
    }
}
