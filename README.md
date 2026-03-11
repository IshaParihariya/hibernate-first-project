# Hibernate CRUD Example

This project demonstrates basic CRUD operations using Hibernate ORM with Java and MySQL. It includes entity mapping, session management, transaction handling, and both standard and non-standard Hibernate configuration approaches.

## Features

- Hibernate ORM setup
- Entity mapping using annotations
- Implementation of getter and setter methods
- Full CRUD operations (Create, Read, Update, Delete)
- Hibernate Session and Transaction management
- Standard Hibernate configuration
- Non-standard configuration approach
- MySQL database integration

## CRUD Operations Implemented

Create  
Insert student records into the database using Hibernate.

Read  
Fetch student data from the database using Hibernate session methods.

Update  
Modify existing student records.

Delete  
Remove student records from the database.

## Technologies Used

- Java
- Hibernate ORM
- MySQL
- Maven

## Project Structure

```
src/main/java
│
├── Student.java        (Entity Class)
├── InsertStudent.java
├── FetchStudent.java
├── UpdateStudent.java
└── DeleteStudent.java

resources
└── hibernate.cfg.xml

pom.xml
```
## Key Concepts Practiced

- Hibernate Configuration
- Entity Mapping
- SessionFactory and Session
- Transaction Management
- CRUD operations using Hibernate

## Purpose

This project was built while learning Hibernate ORM to understand how Java applications interact with relational databases using Object Relational Mapping.
