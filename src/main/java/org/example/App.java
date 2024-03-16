package org.example;


import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = null;
        Session session               = null;
        try {
            Configuration configuration   = new Configuration().addAnnotatedClass(User.class);
            sessionFactory                = configuration.buildSessionFactory();
            session                       = sessionFactory.getCurrentSession();

            session.beginTransaction();
            // java code


            // SELECT -----------------------------------------
//            User user = session.get(User.class, 5 );
//            System.out.println(user);
//            List<User> users = session.createQuery("from User").getResultList();
//            users.forEach(System.out::println);

//            List<User> users = session.createQuery("from User where age > 22").getResultList();
//            users.forEach(System.out::println);

            // INSERT -----------------------------------------
//        User user1 = new User("Bekow", 21);
//        User user2 = new User("Alua", 22);
//        User user3 = new User("Samad", 22);

//        session.save(user1);
//        session.save(user2);
//        session.save(user3);

            // DELETE -----------------------------------------
//            User user = session.get(User.class, 5 );
//            session.delete(user);

//            session.createQuery("delete User where age > 22").executeUpdate();

            // UPDATE -----------------------------------------
//            User user = session.get(User.class, 4 );
//            user.setName("Dana");
//            session.save(user);

//            session.createQuery("update User set age = 23 where name = 'Daryn'").executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
