package com.example.azphyo.dataparceltest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by azphyo on 10/21/2017.
 */

public class Student implements Parcelable{

    String name;
    int age;
    String address;
    String university;
    String bachelor;
    String carrier;
    String profession;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getBachelor() {
        return bachelor;
    }

    public void setBachelor(String bachelor) {
        this.bachelor = bachelor;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    protected Student(Parcel in) {
        name = in.readString();
        age = in.readInt();
        address = in.readString();
        university = in.readString();
        bachelor = in.readString();
        carrier = in.readString();
        profession = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public Student() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeString(address);
        parcel.writeString(university);
        parcel.writeString(bachelor);
        parcel.writeString(carrier);
        parcel.writeString(profession);
    }
}
