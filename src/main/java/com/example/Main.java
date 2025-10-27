package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setName("Juan Pérez");
        student.setAge(20);

        session.save(student);
        tx.commit();
        session.close();

        System.out.println("Estudiante guardado con ID: " + student.getId());
        
        HibernateUtil.shutdown();
    }
}
