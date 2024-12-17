package org.abhinandanpdy;

import org.abhinandanpdy.entity.AnnotatedQuestion;
import org.abhinandanpdy.entity.Question;
import org.abhinandanpdy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;

public class App {
    public static void main( String[] args ) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // Performs lifecycle operations under a transaction
        Transaction transaction = null;

        try {
            // Start a transaction
            transaction = session.beginTransaction();

            // Create and save employee objects
//            Question ques = new Question();
//            ques.setQname("Which of the following is not an ORM framework?");
//            ques.setOptions(Arrays.asList("A) Hibernate", "B) TopLink", "C) MyBatis (iBatis)", "D) Spring Data JPA"));
//
//            ques.setAnswer("D) Spring Data JPA (Spring Data JPA is a Java-based ORM tool, but not a standalone ORM framework like Hibernate, TopLink, and MyBatis)");

            AnnotatedQuestion ques = new AnnotatedQuestion();
            ques.setQname("What does ORM stand for?");
            ques.setOptions(Arrays.asList("A) Object Relational Model", "B) Object Resource Mapping", "C) Object Relational Mapping", "D) Object Reference Mapping"));

            ques.setAnswer("C) Object Relational Mapping");

            session.save(ques);

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}