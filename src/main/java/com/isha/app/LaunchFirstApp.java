package com.isha.app;

import com.isha.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchFirstApp {
    public static void main(String[] args)
    {
        // step 1 configuration object
        Configuration config = new Configuration();

        // step 2 configure hibernate.cfg.xml file to Configuration object
        config.configure(); // if name of xml file is something else than this default one hibernate.cfg.xml then need to specify here (" ")

        // step 3 Create SessionFactory object
        SessionFactory sessionFactory = config.buildSessionFactory();

        // step 4 get session object from the SessionFactory
        Session session = sessionFactory.openSession();

        // step 5 begin the Transaction within the session
        Transaction transaction=session.beginTransaction();

        Student student =new Student();
        student.setSid(1);
        student.setSname("Isha Parihariya");
        student.setScity("Surat");

        // step 6 Perform operation
        session.save(student);

        // step 7 performing Transaction operations
        transaction.commit();

        // step 8 close the session
        session.close();

    }
}