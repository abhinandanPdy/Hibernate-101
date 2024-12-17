package org.abhinandanpdy.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            // "hibernate.cfg.xml" is optional for .configure("hibernate.cfg.xml").


//            Required for Hibernate 5.6.10 not with 4.3.11
            configuration.addResource("Employee.hbm.xml");

            System.out.println("Hibernate Mapping file added...");

            System.out.println("Hibernate Configuration loaded...");

            // Used to register entity mapping
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            System.out.println("Hibernate serviceRegistry created...");

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
