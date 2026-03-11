package com.isha.app;

import com.isha.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchUpdateApp
{
    // for the updation of the data
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        // try block
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Student student = new Student();
            student.setSid(1); // at id==1 already data entered so it will update it
            student.setSname("Kunal Parihariya");
            student.setScity("Atlanta");

            // older one and strict : session.update(student);
            // another way : session.saveOrUpdate(student);
            // new and flexible way
            /*
            merge bcuz Hibernate first checks if the object already exists in the session, then merges changes. and update() directly updates so..
             */
            session.merge(student);
            flag = true;
        }
        // catch blocks
        catch (HibernateException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // finally block
        finally
        {
        if (flag == true)
        {
            transaction.commit();
        }
        else
        {
            transaction.rollback();
        }
        session.close();
        sessionFactory.close();
    }
    }
}
