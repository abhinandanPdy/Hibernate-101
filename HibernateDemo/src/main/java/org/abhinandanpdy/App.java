package org.abhinandanpdy;

import org.abhinandanpdy.entity.Employee;
import org.abhinandanpdy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    private static void saveEmployee(Session session, Employee employee) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

            System.out.println("Employee saved successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private static void updateEmployeeSalary(Session session, int id, int newSalary) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Employee employee = (Employee) session.get(Employee.class, id);
            employee.setEmpSalary(newSalary);

            session.update(employee);

            transaction.commit();

            employee = (Employee) session.get(Employee.class, id);
            if (employee.getEmpSalary() == newSalary)
                System.out.println("Employee updated successfully.");
            else
                throw new Exception("Employee not updated.");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private static void deleteEmployee(Session session, int id) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Employee employee = (Employee) session.get(Employee.class, id);

            if (employee != null){

                session.delete(employee);
                transaction.commit();
                System.out.println("Employee deleted successfully.");
            }
            else
                System.out.println("Employee does not exist");

//            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {

        Session session = HibernateUtil.getSessionFactory().openSession();


        saveEmployee(session,
                new Employee("Lalit", "Intern", (int)(Math.random() * 10000))
        );

        updateEmployeeSalary(session, 2, (int)(Math.random() * 1000));

        deleteEmployee(session, 3);

        session.close();

    }


}