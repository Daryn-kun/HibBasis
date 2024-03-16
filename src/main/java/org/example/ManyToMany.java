package org.example;

import org.example.entity.InfoStudent;
import org.example.entity.Student;
import org.example.entity.StudentGroup;
import org.example.entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToMany {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session               = null;
        try {
            Configuration configuration   = new Configuration()
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(InfoStudent.class)
                    .addAnnotatedClass(StudentGroup.class)
                    .addAnnotatedClass(Subject.class);
            sessionFactory                = configuration.buildSessionFactory();
            session                       = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            INSERT START -------------------------------------------------------------------
            Student student = session.get(Student.class, 4);
            Subject subject = new Subject("ios", 7);
            student.addSubjects(subject);

            session.save(student);
//            INSERT END -------------------------------------------------------------------

            // SELECT START ----------------------------------------------------------------
//            StudentGroup studentGroup = session.get(StudentGroup.class, 1);
//            System.out.println(studentGroup.getStudents());

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
