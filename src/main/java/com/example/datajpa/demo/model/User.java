package com.example.datajpa.demo.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER_PHONE")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surName;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany
    private List<Phone> phone;

    public User(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public User(String name, String surName, List<Phone> phone) {
        this.name = name;
        this.surName = surName;
        this.phone = phone;
    }

}
