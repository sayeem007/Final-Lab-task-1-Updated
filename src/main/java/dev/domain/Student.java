package dev.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Student {

    private int id;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters")
    private String name;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Incorrect email format")
    private String email;

    @NotNull
    @Past(message = "Date of birth must be in the past")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dob;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Quota is required")
    private String quota;

    @NotNull(message = "Country is required")
    private String country="Bangladeshi";

    public Student() {
    }

    public Student(int id, String name, String email, LocalDate dob, Gender gender, String quota, String country) {
        this.id= id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.quota = quota;
        this.country = country;
    }

    // Getters and setters for all attributes


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
