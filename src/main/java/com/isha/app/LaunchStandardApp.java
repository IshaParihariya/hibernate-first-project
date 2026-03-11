package com.isha.app;

import com.isha.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchStandardApp
{
    // standard way
    public static void main(String[] args)
    {/*
    save() : Insert may happen immediately. (only specific to Hibernate)
    persist() : Insert happens when transaction commits. (for JPA)
    */

        // why null ???
        // to declare variables first so they can be used in try–catch–finally blocks.
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        boolean flag=false;

        // Configuartion object
        config = new Configuration();

        // configure xml file
        config.configure();

        // sessionFactory object
        sessionFactory=config.buildSessionFactory();

        // get session object from sessionFactory
        session = sessionFactory.openSession();

        Student student =new Student();
        student.setSid(2);
        student.setSname("Mohit Parihariya");
        student.setScity("Jaipur");

        // try and catch block for exception handling
        try
        {
            // begin the transaction
            transaction=session.beginTransaction();
            // persist() same as save() but preferable
            session.persist(student); // saving student object for a long time
            flag=true;
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(flag==true) //it means done with the operation hence commit
            {
                transaction.commit();
            }
            else
            {
                // if not done with the operation then just rollback i.e., no changes at all
                transaction.rollback();
            }
            session.close();
            sessionFactory.close();
        }

    }

}
