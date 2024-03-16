package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
@NoArgsConstructor
@RequiredArgsConstructor
public @Data
class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "movieList")
    private List<Actor> actors;
}
