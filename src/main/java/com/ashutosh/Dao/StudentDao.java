package com.ashutosh.Dao;

import com.ashutosh.Entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentByID(int id);

    void removeStudentByID(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
