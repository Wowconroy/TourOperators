package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "user_db")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    private String username;
    private String lastName;
    private LocalDate dob;
    //Need to add relations -> ROLE (One to One)

    @Transient
    private Integer age;

    public User() {
    }

    public User(String username, String lastName, LocalDate dob) {
        this.username = username;
        this.lastName = lastName;
        this.dob = dob;
    }

    public User(Long id, String username, String lastName, LocalDate dob) {
        this.id = id;
        this.username = username;
        this.lastName = lastName;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
