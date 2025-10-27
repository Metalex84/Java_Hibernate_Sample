package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Student student1 = new Student();
            student1.setName("Juan Pérez");
            student1.setAge(20);

            Student student2 = new Student("María Gómez", 22);

            session.persist(student1);
            session.persist(student2);
            tx.commit();

            System.out.println("Estudiante guardado con ID: " + student1.getId());
            System.out.println("Estudiante guardado con ID: " + student2.getId());
            
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
