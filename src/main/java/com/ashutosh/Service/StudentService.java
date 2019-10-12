package com.ashutosh.Service;

import com.ashutosh.Dao.StudentDao;
import com.ashutosh.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service

public class StudentService {

    @Qualifier("jdbc")
    @Autowired
    StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }

    public Student getStudentByID(int id){
        return this.studentDao.getStudentByID(id);

    }

    public void removeStudentByID(int id) {
        this.studentDao.removeStudentByID(id);
    }

    public void updateStudent(Student student){
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudent(student);
    }
}
