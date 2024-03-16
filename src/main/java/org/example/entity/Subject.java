package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
@NoArgsConstructor
@RequiredArgsConstructor
public @Data
class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "credit")
    @NonNull
    private double credit;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name               = "students_subjects",
               joinColumns        = @JoinColumn(name = "subjects_id"),
               inverseJoinColumns = @JoinColumn(name = "students_id"))
    private List<Student> studentList;

    public void addStudent(Student student){
        if (studentList == null){
            studentList = new ArrayList<>();
        }

        studentList.add(student);
    }
}
