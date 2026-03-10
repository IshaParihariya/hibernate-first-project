package com.isha.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity tells Hibernate (JPA) that this Java class represents a table in the database
// NOTE : studied in dbms entity = table name or relation and attributes = column names
@Entity
@Table(name = "StudentDetails") // to specify name of the table in the db if not specifies then class name will be the table name
public class Student
{
    @Id // to specify its a primary key
    @Column(name = "SID") // to specify the column name if not specifies then variable name will be the column name
   private Integer sid;
    @Column(name = "SNAME")
   private String sname;
    @Column(name = "SCITY")
   private String scity;


    // NOTE : entity should have a non parameterized constructor
    // zero paramaterised constructor
    //IMP : **Hibernate uses reflection to create entity objects, so a default no-argument constructor is required for object instantiation
    public Student()
    {
        System.out.println("zero parameterized constructor");
    }

    // getter and setter
    // hibernate usually expects setters .Without setters, Hibernate may not properly populate fields
    public Integer getSid()
    {
        return sid;
    }
    public void setSid(Integer sid)
    {
        this.sid=sid;
    }

    public String getSname()
    {
        return sname;
    }
    public void setSname(String sname)
    {
        this.sname=sname;
    }

    public String getScity()
    {
        return scity;
    }
    public  void setScity(String scity)
    {
        this.scity=scity;
    }


    public String toString()
    {
        return "Student [sid = "+sid+" , sname = "+sname+" , scity = "+scity+" ]";
    }
}
