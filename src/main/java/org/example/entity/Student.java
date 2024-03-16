package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@NoArgsConstructor
@RequiredArgsConstructor
public @Data class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "university")
    @NonNull
    private String university;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "infoStudents_id")
    @NonNull
    private InfoStudent infoStudent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentGroup_id")
    @NonNull
    private StudentGroup studentGroup;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name               = "students_subjects",
               joinColumns        = @JoinColumn(name = "students_id"),
               inverseJoinColumns = @JoinColumn(name = "subjects_id"))
    private List<Subject> subjectList;

    public void addSubjects(Subject subject){
        if (subjectList == null){
            subjectList = new ArrayList<>();
        }

        subjectList.add(subject);
    }
}
