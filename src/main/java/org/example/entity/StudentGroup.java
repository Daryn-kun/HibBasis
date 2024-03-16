package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studentGroup")
@NoArgsConstructor
@RequiredArgsConstructor
public @Data
class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NonNull
    private String name;

    @OneToMany(mappedBy = "studentGroup",
               cascade  = CascadeType.ALL )
    @NonNull
    private List<Student> students;

    public void addStudent(Student student){
        if (students == null){
            students = new ArrayList<>();
        }

        students.add(student);
        student.setStudentGroup(this);
    }

}
