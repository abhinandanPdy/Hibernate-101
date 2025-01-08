package org.abhinandanpdy;

import org.abhinandanpdy.entity.Employee;
import org.abhinandanpdy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppOld {
    public static void main( String[] args ) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // Performs lifecycle operations under a transaction
        Transaction transaction = null;

        try {
            // Start a transaction
            transaction = session.beginTransaction();

            // Create and save employee objects
            Employee emp = new Employee("Abhi", "SDE", (int)(Math.random() * 10000));

            session.save(emp);

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