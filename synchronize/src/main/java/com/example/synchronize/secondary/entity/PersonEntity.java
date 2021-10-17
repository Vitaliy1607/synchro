package com.example.synchronize.secondary.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "Person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String firstName;
    private String lastName;
    private String gender;


//    @OneToMany(mappedBy = "person")
//    private List<AccountPersonEntity> accountPersons;
//
//    @OneToMany(mappedBy = "person")
//    private List<TeamPersonEntity> teamPersons;

}
