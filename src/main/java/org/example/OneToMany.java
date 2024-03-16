package org.example;

import org.example.entity.InfoStudent;
import org.example.entity.Student;
import org.example.entity.StudentGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToMany {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session               = null;
        try {
            Configuration configuration   = new Configuration()
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(InfoStudent.class)
                    .addAnnotatedClass(StudentGroup.class);
            sessionFactory                = configuration.buildSessionFactory();
            session                       = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            INSERT START -------------------------------------------------------------------
//            Student student1 = new Student("IITU");
//            Student student2 = new Student("KBTU");
//            Student student3 = new Student("SDU");
//
//            InfoStudent infoStudent1 = new InfoStudent("Daryn", 3.89, "87577778899");
//            InfoStudent infoStudent2 = new InfoStudent("Nadira", 3.78, "87577778899");
//            InfoStudent infoStudent3 = new InfoStudent("Daur", 3.47, "87577778899");
//
//            student1.setInfoStudent(infoStudent1);
//            student2.setInfoStudent(infoStudent2);
//            student3.setInfoStudent(infoStudent3);
//
//            StudentGroup studentGroup = new StudentGroup("IS");
//            studentGroup.addStudent(student1);
//            studentGroup.addStudent(student2);
//            studentGroup.addStudent(student3);
//
//            session.save(studentGroup);
//            INSERT END -------------------------------------------------------------------

            // SELECT START ----------------------------------------------------------------
            StudentGroup studentGroup = session.get(StudentGroup.class, 1);
            System.out.println(studentGroup.getStudents());

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
