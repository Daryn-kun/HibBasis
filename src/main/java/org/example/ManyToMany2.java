package org.example;

import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManyToMany2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session               = null;
        try {
            Configuration configuration   = new Configuration()
                    .addAnnotatedClass(Movie.class)
                    .addAnnotatedClass(Actor.class);
            sessionFactory                = configuration.buildSessionFactory();
            session                       = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // INSERT START ------------------------------------------------------
//            Movie movie  = new Movie("Harry Potter");
//            Actor actor1 = new Actor("Daniel Radcliff", 33);
//            Actor actor2 = new Actor("Emma Watson", 32);
//            Actor actor3 = new Actor("Ron Wisley", 34);
//
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2, actor3)));
//
//            actor1.setMovieList(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovieList(new ArrayList<>(Collections.singletonList(movie)));
//            actor3.setMovieList(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);
//            session.save(actor3);
            // INSERT END ------------------------------------------------------

            // SELECT START ----------------------------------------------------
            Movie movie = session.get(Movie.class, 1);
            System.out.println(movie);
            System.out.println(movie.getActors());

            // SELECT END ------------------------------------------------------
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
