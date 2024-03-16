package org.example;

import org.example.entity.InfoStudent;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session               = null;
        try {
            Configuration configuration   = new Configuration()
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(InfoStudent.class);
            sessionFactory                = configuration.buildSessionFactory();
            session                       = sessionFactory.getCurrentSession();

//            Student student = new Student("KBTU", "ITM2022");
//            student.setInfoStudent(new InfoStudent("Anel", 3.56, "87779990022"));

            InfoStudent infoStudent = new InfoStudent("Daur", 3.28, "87478882244");
            Student student         = new Student();
            infoStudent.setStudent(student);
            student.setInfoStudent(infoStudent);

            session.beginTransaction();

            session.save(infoStudent);
//            Student student = session.get(Student.class, 2);
//            System.out.println(student.getInfoStudent().getName());
//            session.delete(student);


            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
