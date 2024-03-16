package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "infoStudents")
@NoArgsConstructor
@RequiredArgsConstructor
public @Data
class InfoStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "gpa")
    @NonNull
    private double gpa;

    @Column(name = "phone_number")
    @NonNull
    private String phone_number;

    @OneToOne(mappedBy = "infoStudent",
              cascade  = CascadeType.ALL)
    private Student student;

}
