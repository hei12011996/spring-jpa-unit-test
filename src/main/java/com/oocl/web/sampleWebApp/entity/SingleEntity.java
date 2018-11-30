package com.oocl.web.sampleWebApp.entity;


import javax.persistence.*;

@Entity
public class SingleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(length = 10)
    public String name;

    public SingleEntity(){

    }

}
