package com.isha.app;

import com.isha.model.Student;
import jakarta.persistence.EntityGraph;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.graph.RootGraph;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.relational.SchemaManager;
import org.hibernate.stat.Statistics;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

public class LaunchDeleteApp
{
    // for the deletion of the data
    public static void main(String[] args)
    {
        // one way
        /*
        Configuration config=null;
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction transaction=null;

        // Configuration object
        config= new Configuration();

        // configure the xml file
        config.configure();

        // SessionFcatory object
        sessionFactory=config.buildSessionFactory();

        // session
        session=sessionFactory.openSession();
*/

        // even precise way
       SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
       //Session session=sessionFactory.openSession();
        Session session=null; // so can access everywhere
        Transaction transaction=null;
        boolean flag=false;

        // try
        try
        {
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            Student student =new Student();
            student.setSid(2);
            student.setSname("Mohit parihariya");
            student.setScity("Jaipur");

            //older one
            //session.delete(student);

            // newer one
            session.remove(student);

            flag=true;

        }
        // catch
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
